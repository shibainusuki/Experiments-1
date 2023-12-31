package com.example.experiments.jetpackcompose.layout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.experiments.R
import kotlinx.coroutines.launch

class Pager {

    @OptIn(ExperimentalFoundationApi::class)
    @Preview
    @Composable
    fun ExperimentalPager() {
        val images = listOf(
            painterResource(id = R.drawable.pagu1),
            painterResource(id = R.drawable.cat_1),
            painterResource(id = R.drawable.fishes_1)
        )
        val pagerState = rememberPagerState(pageCount = {
            images.size
        })

        val scope = rememberCoroutineScope()

        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            HorizontalPager(
                //画像のサイズが均一ではないので、最も大きい画像でも入るPagerの高さに設定している。
                // 画像の高さに合わせて高さが調整されるようにすると、下の矢印の位置が画像のサイズに合わせて変わってしまう。
                modifier = Modifier.height(350.dp),
                state = pagerState,
            ) { page ->
                // Our page content
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                        painter = images[page],
                        contentDescription = ""
                    )
                    Text(
                        text = "Page: $page",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                IconButton(onClick = {
                    scope.launch {
                        pagerState.scrollToPage((pagerState.currentPage + 1) % pagerState.pageCount)
                    }
                }) {
                    Icon(
                        modifier = Modifier.size(64.dp),
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "進むボタン"
                    )
                }
            }
        }
    }
}