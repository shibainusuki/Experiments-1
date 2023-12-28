package com.example.experiments.jetpackcompose.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.experiments.R
import kotlinx.coroutines.launch

class Scaffold {

    @Preview
    @Composable
    fun ShowPreview() {

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun CreateScaffold() {
        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }
        Scaffold(
            //snackbarの実装
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
            floatingActionButton = {
                //ExtendedFloatingActionButtonでなくても実装は可能。ただしまあまあダサい。
                Row(modifier = Modifier
                    .background(Color.Gray)
                    .wrapContentWidth()
                    .clickable {
                        scope.launch {
                            snackbarHostState.showSnackbar("Snackbar")
                        }
                    }) {
                    Icon(Icons.Default.Call, contentDescription = "")
                    Text(text = "スナックバーボタンです")
                }
//                ExtendedFloatingActionButton(
//                    text = { Text("call me back soon !") },
//                    icon = { Icon(Icons.Default.Call, contentDescription = "") },
//                    onClick = {
//                        scope.launch {
//                            snackbarHostState.showSnackbar("Snackbar")
//                        }
//                    }
//                )
            },
            topBar = { CreateTopBar() },
            bottomBar = { CreateBottomBar() }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = stringResource(id = R.string.app_name),
                    fontSize = 30.sp
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun CreateTopBar() {
        TopAppBar(title = { Text("テストヘッダー") },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = null
                )
            },
            actions = {
                // アクションボタンなどを配置
                IconButton(onClick = { println("メニューがタップされました") }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                }
            }
        )
    }

    @Preview
    @Composable
    fun CreateBottomBar() {
        Box(modifier = Modifier.fillMaxWidth(), Alignment.Center) {
            Column(
                modifier = Modifier
                    .clickable { println("フッターボタンがタップされました") }
                    .padding(start = 8.dp, end = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
                Text(text = stringResource(id = R.string.app_bottom_text))
            }
        }
    }
}