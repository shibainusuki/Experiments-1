package com.example.experiments.jetpackcompose.sideeffect

import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
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
                scope.launch { snackbarHostState.showSnackbar("Hello, World")
                }
            }
        ) {
            Text(text = "Show SnackBar")
        }
        SnackbarHost(hostState = snackbarHostState)
    }
        @Preview
        @Composable
        fun showPreview() {
            LaunchedEffectBehavior()
        }
}