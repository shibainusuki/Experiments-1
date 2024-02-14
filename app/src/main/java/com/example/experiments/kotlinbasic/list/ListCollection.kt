package com.example.experiments.kotlinbasic.list

class ListCollection {

    //----------mapの挙動-----------
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

    //参考記事: https://maku77.github.io/kotlin/collection/map.html
    /**
     * リストの各要素を取り出して2倍にしたリストにする
     */
    fun mapNumListToDoubleNum() {
        val numList = listOf(1, 2, 3)
        val numDoubleNumList = numList.map { 2 * it }
        println("numDoubleList:$numDoubleNumList")
        //出力結果：numDoubleList:[2, 4, 6]
    }

    //Dataクラスから要素を取り出して新たにリストを作成する
    data class User(val id: Int, val name: String)

    /**
     * Userリストの各IDを取り出して新たにリストを作成する
     */
    fun extractUserIds() {
        val userIds = listOf(
            User(3298, "Taro"),
            User(5090, "Hanako"),
            User(2278, "Tom")
        ).map { it.id }
        println("userIds:$userIds")
        //出力結果userIds:[3298, 5090, 2278]
    }


    /**
     * Dataクラスの各要素を取り出して、それぞれのリストを作成する
     *
     */
    fun extractUserIdsAndUserName() {
        val ids = arrayListOf<Int>()
        val names = arrayListOf<String>()

        listOf(
            User(3298, "Taro"),
            User(5090, "Hanako"),
            User(2278, "Tom")
        ).map { (userId, userName) ->
            ids.add(userId)
            names.add(userName)
        }
        println("ids:$ids")
        println("names:$names")
        //出力結果 Ids:[3298, 5090, 2278]
        //出力結果 names:[Taro, Hanako, Tom]
    }


    //---------------filterの挙動-------------------
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

    //----------indicesの挙動-----------
    fun printMembersName() {
        val members = listOf("Bob", "Taro", "Hanako", "Tomi")
        println("members.indices: ${members.indices}")
        for (i in members.indices) {
            println("members Name is: ${members[i]}")
        }
        //出力結果
        //    members.indices: 0..3
        //    Name is: Bob
        //    Name is: Taro
        //    Name is: Hanako
        //    Name is: Tomi
    }

    //----------zipの挙動-----------
    fun zip() {
        val numbers = listOf(1, 2, 3)
        val stringNumbers = listOf("one", "two", "three", "four")
        val bigNumbers = listOf(1000, 2000, 3000)
        val pairList: List<Pair<Int, String>> = numbers.zip(stringNumbers)
        println("zip()の出力結果：$pairList")

        //出力結果
        //zip()の出力結果：[(1, one), (2, two), (3, three)]

        //リストになっているPairの要素を取り出して何かをする
        for ((number, numString) in pairList) {
            println("number:$number numString:$numString")

            //出力結果
            //number:1 numString:one
            //number:2 numString:two
            //number:3 numString:three
        }

        //Pairの要素を変換してリストにして返す
        val multiplicationResultList: List<Int> =
            numbers.zip(bigNumbers) { number, bigNumber -> number * bigNumber }
        println("multiplicationResultList: $multiplicationResultList")
        //出力結果：multiplicationResultList: [1000, 4000, 9000]

        multiplicationResultList.forEach {
            println("multiplicationResult:$it")
            //出力結果
            //"multiplicationResult:1000
            //"multiplicationResult:4000
            //"multiplicationResult:9000
        }

        //使用例
        //例えばWebのリンク先のリストと、それを表示するUIのバインディング先をペアにして、紐付けるとか。。
        //以下の場合はリンクの数が0〜3で変動するが、UIの表示は最大数の３つ分用意しなければならないことを想定している
        /*val bindings = listOf(binding.linkFirst, binding.linkSecond, binding.LinkThird)
        val pairList: List<Pair<LinkEntity, AppCompatTextView>> = links.zip(bindings)
        for ((link, view) in pairList) {
            setupLink(link, view)*/
    }
}