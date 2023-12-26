package com.example.experiments.jetpackcompose.sideeffect

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LaunchedEffect {
    @Composable
    fun LaunchedEffectBehavior() {
        val snackbarHostState = remember { SnackbarHostState() }

        //Coroutineを起動する場合はrememberCoroutineScope()でscopeを取得して、そこからlaunchする
        //snackBarはsuspendなのでCoroutineScope内で呼び出す必要がある
        val scope = rememberCoroutineScope()
        Button(
            onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar("Hello, World")
                }
            }
        ) {
            Text(text = "Show SnackBar")
        }
        SnackbarHost(hostState = snackbarHostState)
    }

    @Composable
    fun LaunchedEffectBehavior2() {
        var showSnackBar by remember { mutableStateOf(false) }
        val snackbarHostState = remember { SnackbarHostState() }
        LaunchedEffect(key1 = showSnackBar) {
            if (showSnackBar) {
                snackbarHostState.showSnackbar("Hello, World")
            }
            (1..5000).forEach { i ->
                delay(5000)
                showSnackBar = !showSnackBar
                println("テスト showSnackBar is $showSnackBar")
                println("テスト Count is $i")
            }
        }
        SnackbarHost(hostState = snackbarHostState)
    }

    @Composable
    //LaunchedEffectBehavior2()のfor文の処理が累積していくのを改善した
    fun LaunchedEffectBehavior3() {
        var showSnackBar by remember { mutableStateOf(true) }
        val snackbarHostState = remember { SnackbarHostState() }
        var elapsedTime by remember { mutableStateOf(0) }

        LaunchedEffect(key1 = showSnackBar) {
            while (showSnackBar) {
                delay(1000)
                elapsedTime += 1

                //スナックバーの表示中（約5秒）はスレッドが止められるらしく、 delay(1000)としているが
                // 実際には約5秒ごとにelapsedTimeがインクリメントされる。
                snackbarHostState.showSnackbar("Hello, World")
                println("テスト showSnackBar is $showSnackBar")
                println("テスト elapsedTime is $elapsedTime")
                if (elapsedTime > 5) {
                    showSnackBar = !showSnackBar
                }
            }
        }
        SnackbarHost(hostState = snackbarHostState)
    }

    @Composable
    fun LaunchedEffectBehavior4() {
        val snackbarHostState = remember { SnackbarHostState() }

        val scope = rememberCoroutineScope()

        Button(onClick = {
            scope.launch {
                snackbarHostState.showSnackbar("Hello, World")
            } 
        }
        ) {
            Text(text = "スナックバーを表示する")
        }
        SnackbarHost(hostState = snackbarHostState)
    }


    @Composable
    fun LaunchedEffectBehavior5() {
        val snackbarHostState = remember { SnackbarHostState() }

        val scope = rememberCoroutineScope()
        //scope.launch { snackbarHostState.showSnackbar("Hello, World") }

        LaunchedEffect(Unit){
            snackbarHostState.showSnackbar("Hello, World")
        }

        SnackbarHost(hostState = snackbarHostState)
    }

    @Preview
    @Composable
    fun showPreview() {
        //LaunchedEffectBehavior()
        //LaunchedEffectBehavior2()
        //LaunchedEffectBehavior3()
        //LaunchedEffectBehavior4()
        LaunchedEffectBehavior5()
    }

    fun hoge(vararg args: String){

    }
}