package com.example.experiments.kotlinbasic.constractor

//constructorは省略可能
class ConstructorExp constructor(val name: String, private var age: Int) {

    init {
        println("ユーザー名は$name です。年齢は$age です")
        //nameはProductのコンストラクタの初期値として設定しているので省略可能
        //Product(price = 150)

        //Product(name = "Pixel8", 76000)

        Product(name = "チョコパイ")
    }

    class Product(val name: String = "ポッキー", private var price: Int) {
        init {
            println("${name}の値段は${price}です")
        }

        //Productがnameだけ指定されてインスタンス生成された時に発動するセカンダリコンストラクタ
        //例えばセカンダリコンストラクタがない場合、Product(name = "チョコパイ")のようにインスタンス生成した場合、
        //priceが指定されていないためエラーになってしまう。
        constructor(name: String) : this(price = 300) {
            println("$name の値段は$price 円です")
        }
    }
}