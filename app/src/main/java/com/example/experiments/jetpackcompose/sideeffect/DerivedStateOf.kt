package com.example.experiments.jetpackcompose.sideeffect

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class DerivedStateOf {

    @Composable
    fun DerivedStateOfBehavior1(names: List<String>, onNameClicked: (String) -> Unit) {
        Box {
            val listState = rememberLazyListState()
            //derivedStateOfの中の判定が変わった時にだけ再コンポーズが起きる。
            //val isShowButton by remember { derivedStateOf { listState.firstVisibleItemIndex > 0 } }
            val isShowButton = listState.firstVisibleItemIndex > 0
            Log.d("テスト", "再コンポーズされました")
            LazyColumn(state = listState) {
                items(names) { name ->
                    NamePickerItem(name = name, onClicked = onNameClicked)
                }
            }
            if (isShowButton) {
                Button(onClick = { }) {
                    Text(text = "ScrollTop")
                }
            }
        }
    }

    @Composable
    fun DerivedStateOfBehavior2(names: List<String>, onNameClicked: (String) -> Unit) {
        Box {
            val listState = rememberLazyListState()
            val isShowButton by remember {
                derivedStateOf { listState.firstVisibleItemIndex > 0 }
            }
            Log.d("テスト", "再コンポーズされました")
            LazyColumn(state = listState) {
                items(names) { name ->
                    NamePickerItem(name = name, onClicked = onNameClicked)
                }
            }
            if (isShowButton) {
                Button(onClick = { }) {
                    Text(text = "ScrollTop")
                }
            }
        }
    }

    @Composable
    private fun NamePickerItem(name: String, onClicked: (String) -> Unit) {
        Text(
            name,
            Modifier
                .clickable(onClick = { onClicked(name) })
                .padding(4.dp)
        )
    }


    @Preview
    @Composable
    fun ShowPreview() {
        val names = arrayListOf<String>()
        (1..100).forEach {
            names.add("name$it")
        }
//        DerivedStateOfBehavior(
//            names = names,
//            onNameClicked = fun(name: String) = println(name))
        DerivedStateOfBehavior2(
            names = names,
            onNameClicked = fun(name: String) = println(name))
    }
}