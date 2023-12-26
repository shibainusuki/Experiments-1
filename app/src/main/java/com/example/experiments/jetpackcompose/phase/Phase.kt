package com.example.experiments.jetpackcompose.phase

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import com.example.experiments.R

class Phase {
    @SuppressLint("PrivateResource")
    @Composable
    //https://developer.android.com/jetpack/compose/phases?hl=ja#optimizing-state-reads
    fun UnOptimizedStateRead(samplesNames: ArrayList<String>) {
        Box {
            val listState = rememberLazyListState()

            Image(
                painter = painterResource(id = androidx.core.R.drawable.ic_call_answer_video),
                contentDescription = "最適化されていない状態読み取りの例",
                modifier = Modifier.offset(
                    with(LocalDensity.current) {
                        // State read of firstVisibleItemScrollOffset in composition
                        (listState.firstVisibleItemScrollOffset / 3).toDp()
                    }
                )
            )
            //サンプル名の一覧を表示する（旧RecyclerView）
            LazyColumn(state = listState) {
                items(samplesNames) { sampleName ->
                    ShowSampleNames(name = sampleName)
                }
            }
        }
        //このコードスクロールする度にログが出力される。
        Log.d("テスト", "Composable直下のログが呼び出されました")
    }

    @Composable
    fun ShowSampleNames(name: String) {
        Text(text = name)
    }


    @SuppressLint("PrivateResource")
    @Composable
    fun OptimizedStateRead(samplesNames: ArrayList<String>) {
        Box {
            val listState = rememberLazyListState()

            Image(
                painter = painterResource(id = androidx.core.R.drawable.ic_call_answer_video),
                contentDescription = "最適化された状態読み取りの例",
                // Modifier.offsetラムダでオフセットを定義することによって、
                //Compositionフェーズでツリー上にオフセットが反映されない（？）ようになり、
                //Layoutフェーズでオフセットが行われることになる。
                modifier = Modifier.offset {
                    IntOffset(x = 0, y = listState.firstVisibleItemScrollOffset / 2)
                }
            )
            //サンプル名の一覧を表示する（旧RecyclerView）
            LazyColumn(state = listState) {
                items(samplesNames) { sampleName ->
                    ShowSampleNames(name = sampleName)
                }
            }
        }
        //このコードスクロールする度にログが出力されない。
        Log.d("テスト", "Composable直下のログが呼び出されました")
    }

    //悪い例
    //再コンポジション ループ（循環型フェーズの依存関係）
    //https://developer.android.com/jetpack/compose/phases?hl=ja#recomp-loop
    @Composable
    fun BudRecomposeLupeExample() {
        Box {
            var imageHeightPx by remember { mutableIntStateOf(0) }

            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "I'm above the text",
                modifier = Modifier
                    .fillMaxWidth()
                    .onSizeChanged { size ->
                        // Don't do this
                        imageHeightPx = size.height
                    }
            )

            Text(
                text = "I'm below the image",
                modifier = Modifier.padding(
                    top = with(LocalDensity.current) { imageHeightPx.toDp() }
                )
            )
        }
    }

    @Preview
    @Composable
    fun ShowPreview() {
        val sampleNames = arrayListOf<String>()
        (1..200).forEach {
            sampleNames.add("Name No.: $it")
        }

        //UnOptimizedStateRead(sampleNames)

        //OptimizedStateRead(samplesNames = sampleNames)

        BudRecomposeLupeExample()
    }

}