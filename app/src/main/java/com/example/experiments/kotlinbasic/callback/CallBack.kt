package com.example.experiments.kotlinbasic.callback

class CallBack {

//    fun printName() {
//        loadName { println("取得したデータは $it です") }
//    }

    //上記のようにitと書いて良い（でも下記のような書き方の方が読みやすいと思う。）
    fun printName() {
        loadName { name -> println("取得したデータは $name です") }
    }

    fun printNameWithRunCatching() {
        loadNameWithoutCallBack().apply {
            println("取得したデータは $this です")
        }
    }

    //ViewModelにあるイメージ。RepositoryのfetchName()を呼び出す
    //fetchName()が成功したらaction( println("取得したデータは $it です"))を実行する
    private fun loadName(action: (String) -> Unit) {
        runCatching { fetchName() }
            .onSuccess(action)
            .onFailure { println("名前の取得に失敗しました") }
    }

    private fun loadNameWithoutCallBack(): Result<String> {
        return runCatching { fetchName() }
            .onSuccess { it }
            .onFailure { "" }
    }

    //Repositoryからリモートのデータを取得する、というイメージ
    private fun fetchName(): String {
        return "太郎"
    }

}