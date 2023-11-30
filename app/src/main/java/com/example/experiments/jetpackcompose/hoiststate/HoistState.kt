package com.example.experiments.jetpackcompose.hoiststate

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview

class HoistState {

    //参考記事（公式ドキュメント）https://developer.android.com/jetpack/compose/state-hoisting?hl=ja

    data class Message(val timestamp: String, val content: String, val id: Int)

    //ホイスティングしていない例（状態とUIの要素を分離していない例）
    @Composable
    fun ChatBubble(
        message: Message
    ) {
        //状態
        var showDetails by rememberSaveable { mutableStateOf(false) } // Define the UI element expanded state

        //状態を表示する側
        ClickableText(
            text = AnnotatedString(message.content),
            onClick = { showDetails = !showDetails } // Apply simple UI logic
        )

        if (showDetails) {
            Text(message.timestamp)
        }
    }

    @Preview
    @Composable
    fun GreetingPreview() {
        ChatBubble(message = Message("2023/11/11", "テストコンテンツです", 0))
    }
}
