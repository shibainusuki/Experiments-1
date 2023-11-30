package com.example.experiments.jetpackcompose.sideeffect

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SideEffect {

    @Composable
    fun RunTimerScreen() {
        val isVisible = remember { mutableStateOf(true) }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            if (isVisible.value)
                TimerScreen()

            if (isVisible.value)
                Button(onClick = { isVisible.value = false }) {
                    Text("Hide the timer")
                }

            if (!isVisible.value) {
                Button(onClick = { isVisible.value = true }) {
                    Text("ReStart the timer")
                }
            }
        }
    }

    @Composable
    fun TimerScreen() {
        val elapsedTime = remember { mutableStateOf(0) }

        //LaunchedEffect(Unit)でもタイマーは動くがHide the Timerを押してもjobが終了せずずっと動き続ける
        //LaunchedEffect(Unit) {
        DisposableEffect(Unit) {
            val scope = CoroutineScope(Dispatchers.Default)
            val job = scope.launch {
                while (true) {
                    delay(1000)
                    elapsedTime.value += 1
                    Log.d("テスト", "Timer is still working ${elapsedTime.value}")
                }
            }

            onDispose {
                job.cancel()
                Log.d("テスト", "job canceled")
            }
        }

        Text(
            text = "Elapsed Time: ${elapsedTime.value}",
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
    }

    @Composable
    fun SideEffectCounter1() {
        // Define a state variable for the count
        val count = remember { mutableStateOf(0) }

        // Use SideEffect to log the current value of count
//        SideEffect {
//            Log.d("テスト", "Count is ${count.value}")
//        }

            Log.d("テスト", "Count is ${count.value}")

        Column {
            Button(onClick = { count.value++ }) {
                Text("Increase Count")
            }

            // With every state update, text is changed and recomposition is triggered
            Text("Counter ${count.value}")
        }
    }

    @Composable
    fun SideEffectCounter2() {
        // Define a state variable for the count
        val count = remember { mutableStateOf(0) }

        // Use SideEffect to log the current value of count
//        SideEffect {
//            Log.d("テスト", "Count is ${count.value}")
//        }

        Log.d("テスト", "Count is ${count.value}")

        Column {
            Button(onClick = { count.value++ },) {
                // This recomposition doesn't trigger the outer side effect
                // every time button has been tapped
                //ButtonもComposableFunctionであり、そのComposable中にネストされているので、
                //SideEffectCounter2そのものは再Composeされない
                //Text("Increase Count ${count.value}")
                Text("Increase Count ${count.value}")
            }
        }
    }

    @Composable
    fun SideEffectCounter3() {
        // Define a state variable for the count
        val count = remember { mutableStateOf(0) }

        // Use SideEffect to log the current value of count
        SideEffect {
            // Called on every recomposition
            Log.d("テスト out side", "Count is ${count.value}")
        }

        Column {
            Button(onClick = { count.value++ }) {
                // Use SideEffect to log the current value of count
                SideEffect {
                    // Called on every recomposition
                    Log.d("テスト inside", "Count is ${count.value}")
                }

                // This recomposition doesn't trigger the outer side effect
                // every time button has been tapped
                Text("Increase Count ${count.value}")
            }
        }
    }

}