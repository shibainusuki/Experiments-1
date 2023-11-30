package com.example.experiments.jetpackcompose.sideeffect

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

class ProduceStateOf {
    //参考記事：https://speakerdeck.com/star_zero/droidkaigi-2023?slide=107
    @Composable
    fun ProduceStateOfBehavior1(){
        //itがcount（状態変数）に変換される。
        val count by produceState(0){
            (1..10).forEach{
                delay(1000)
                value = it
            }
        }
        Text(text = "Count = $count")
    }

    @Preview
    @Composable
    fun ShowPreview(){
        ProduceStateOfBehavior1()
    }
}