package com.example.experiments.jetpackcompose.layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.experiments.R

class Dialog {

    @Preview
    @Composable
    fun AlertDialogScreen() {
        //ダイアログの表示・非表示を切り替えるための状態変数
        var isDialogShowState by remember { mutableStateOf(false) }
        //ダイアログのボタンを選択した結果を受け取る状態変数
        var resultState by remember { mutableStateOf("") }

        val approvedResult = stringResource(R.string.app_dialog_approved_result)
        val canceledResult = stringResource(R.string.app_dialog_canceled_result)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                //「show dialog」ボタンがタップされたら状態変数を変更する。
                //状態変数が変更されたことで、再Composeが実行する。
                modifier = Modifier.clickable { isDialogShowState = true },
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.app_dialog),
                fontSize = 30.sp
            )
            Text(
                modifier = Modifier.padding(top = 16.dp),
                textAlign = TextAlign.Center,
                text = resultState,
                fontSize = 16.sp,
            )

            //「show dialog」ボタンが押されるとisDialogShowStateがtrueになる
            //デフォルトはfalseなので画面が始めて表示された時はこのブロックには入っていかない。
            if (isDialogShowState) {
                AlertDialog(
                    title = { Text(text = stringResource(id = R.string.app_dialog_title)) },
                    text = { Text(text = stringResource(id = R.string.app_dialog_text)) },
                    onDismissRequest = {
                        isDialogShowState = false
                        //ラムダの中で直接Composable関数が呼べないらしく、resultState = stringResource(R.string.app_dialog_canceled_result)
                        //とすると@Composable invocations can only happen from the context of a @Composableというエラーが出る
                        //そのためAlertDialog外でテキストを参照して設定している。
                        resultState = canceledResult
                    },
                    dismissButton = {
                        TextButton(onClick = {
                            isDialogShowState = false
                            resultState = canceledResult
                        })
                        { Text(text = stringResource(id = R.string.app_dialog_dismiss_button)) }
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                isDialogShowState = false
                                resultState = approvedResult
                            }) {
                            Text(text = stringResource(id = R.string.app_dialog_confirm_button))
                        }
                    })
            }
        }
    }
}