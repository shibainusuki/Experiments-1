package com.example.experiments.jetpackcompose.basic

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Basic {

    //参考記事：https://developer.android.com/jetpack/compose/mental-model?hl=ja#any-order
    @Composable
    //@Deprecated("Example with bug")
    fun ListWithBug(myList: List<String>) {
        var items = 0
        var showDetails by rememberSaveable { mutableStateOf(0) }
        val incrementShowDetails: () -> Unit = { showDetails++ }
        val incrementShowItems: () -> Unit = { items++ }

        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                println("Columnが再Composeされました")
                for (item in myList) {
                    Text("Item: $item")
                    items++ // Avoid! Side-effect of the column recomposing.
                }

                //Buttonが再コンポーズされ、UIが更新される。
                Button(onClick = incrementShowDetails) {
                    println("Button1が再Composeされました")
                    Text(text = showDetails.toString())
                }

                //ただの変数を更新しているのでButtonが再コンポーズされず、UIが変化しない
                Button(onClick = incrementShowItems) {
                    println("Button2が実行されました　items:$items")
                    Text(text = items.toString())
                }
            }
            Text("Count: $items")
        }
    }

    /**
     * Display a list of names the user can click with a header
     */
    @Composable
    fun NamePicker(
        header: String,
        names: List<String>,
        onNameClicked: (String) -> Unit
    ) {
        Column {
            // this will recompose when [header] changes, but not when [names] changes
            Text(header, style = MaterialTheme.typography.titleMedium)
            Divider()

            // LazyColumn is the Compose version of a RecyclerView.
            // The lambda passed to items() is similar to a RecyclerView.ViewHolder.
            LazyColumn {
                items(names) { name ->
                    // When an item's [name] updates, the adapter for that item
                    // will recompose. This will not recompose when [header] changes
                    NamePickerItem(name, onNameClicked)
                }
            }
        }
    }

    /**
     * Display a single name the user can click.
     */
    @Composable
    private fun NamePickerItem(name: String, onClicked: (String) -> Unit) {
        Text(
            name,
            Modifier
                .clickable(onClick = { onClicked(name) })
                .padding(16.dp),
        )
    }

    @Composable
    fun MeasureTreeConstructionTime(){
        Row {
           Text(text = "テキスト1",modifier = Modifier.offset(x = 10.dp, y = 10.dp))
            Column {
                Text(text = "テキスト2")
                Text(text = "テキスト3")
            }
        }
    }

    @Preview
    @Composable
    fun ShowPreview() {
        //ListWithBug(myList = arrayListOf("1", "2", "3"))
//        NamePicker(
//            header = "テストヘッダー",
//            names = arrayListOf("name1", "name2", "name3"),
//            onNameClicked = fun(name: String) = println(name))
        MeasureTreeConstructionTime()
    }
}