package com.example.experiments.jetpackcompose.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.experiments.R

class Layout {

    //参考ページ
    //https://developer.android.com/jetpack/compose/layouts/basics
    @Composable
    fun ShowPreview() {
        BasicLayout()
        //UsingModifiers { println("猫の気持ち") }

        //関数オブジェクトを渡すので()の中に直接関数は渡せない,{}で囲む必要がある。
        //UsingModifiers (println("猫の気持ち") )
    }

    @Preview
    @Composable
    fun BasicLayout() {
        Row(
            modifier = Modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.Top,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "最適化されていない状態読み取りの例",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .background(Color.Red),
            )
            Column(verticalArrangement = Arrangement.Center) {
                Text(text = "テスト", fontSize = 30.sp)
            }
        }
    }

    @Preview
    @Composable
    fun UsingModifiers(onClick: () -> Unit = {}) {
        val padding = 16.dp
        Column(
            Modifier
                .clickable(onClick = onClick)
                .padding(padding)
                .fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically ) {
                Image(painter = painterResource(id = R.drawable.cat_1), contentDescription = "ネッコ", modifier = Modifier.weight(1f))
                Text(text = "魚食べたいニャー！！", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.size(padding))

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Card(elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), modifier = Modifier.weight(1f)) {
                    Image(painter = painterResource(id = R.drawable.fishes_1),modifier = Modifier.fillMaxWidth(), contentDescription = "魚たち")
                }
                Text(text = "ネッコ怖い。。", textAlign = TextAlign.Center, modifier = Modifier.weight(1f))
            }
        }
    }
}
