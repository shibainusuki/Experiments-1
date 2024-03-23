package com.example.experiments.kotlinbasic.interfaceabstract

abstract class AbstractAPI : Service {
    override fun fetch(): String {
        //部分的な実装は確定していて共通であるが、
        //別の部分はあやふやでそれぞれの事情によるような場合に
        // abstract→Interfaceの組み合わせが使える
        val jsonString = fetchName()
        return jsonString + "を取得しました"
    }
    abstract fun fetchName(): String
}