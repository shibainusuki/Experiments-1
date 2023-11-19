package com.example.experiments.kotlinbasic.list

class FilterAndMap {

    //mapの挙動
    //参考記事：https://qiita.com/watame/items/87b7923d4f3f59ffb653
    fun mappingList() {
        val fruits = listOf("Strawberry", "Grape", "Orange")

        // fruits の各要素に文字列を追加したListを作成
        //fruits（List）が持っている各要素をitとして取り出し、{}の中で加工して、新しいList(greatFruits)を返す
        val greatFruits = fruits.map {
            "Great $it!" // <- 各要素は"it"として取得できる
        }
        println(fruits)
        println(greatFruits)
    }


    //filterの挙動
    //参考記事：https://qiita.com/watame/items/87b7923d4f3f59ffb653
    fun filteringList() {
        val fruits = listOf("Strawberry", "Grape", "Orange", "")

        //fruits（List）から要素をitとして取り出し、Listを再構成する
        val gFruits = fruits.filter {
            // 要素をすべて小文字にし、大文字小文字関係なく"g"が入っているかをチェック
            it.isNotEmpty() // <- 各要素は"it"として取得できる
        }
        println(fruits)
        println(gFruits)
    }

    fun recreateFruitList() {
        val fruits = listOf("Strawberry", "Grape", "Orange", "", "")

        fruits.filter { it.isNotEmpty() }.map { "Great$it" }.also { println(it) }

    }
}