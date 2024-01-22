package com.example.experiments.kotlinbasic.functionobject

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable

class FunctionObject {
    //関数オブジェクトに関するコード


    fun publishTicketScreen(
        hogeId: Int,
        onPublished: (Int) -> Unit
    ) {
        //渡ってきた関数オブジェクトを使って何かする
         onPublished(12)
    }


}