package com.example.experiments.jetpackcompose.layout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.experiments.R

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
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState,
        ) { page ->
            // Our page content
            Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
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
    }
}