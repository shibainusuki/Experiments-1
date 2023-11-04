package com.example.experiments.aroundlambda

class Closure {
    //やさしいKotlin入門 38章 クロージャ
    //NOTE クロージャとは:関数オブジェクトを作った時点での情報を関数オブジェクトの中にずっと保管しておくことができる、というもの
    fun closureMain() {
        val closure1 = getTextClosure("さん")
        val closure2 = getTextClosure("くん")
        val closure3 = getTextClosure("ちゃん")

        val name1 = closure1("タケシ")
        val name2 = closure2("タケシ")
        val name3 = closure3("タケシ")

        println(name1)
        println(name2)
        println(name3)
    }

    //・(String) -> String
    // 　Stringを引数として受け取り、Stringを戻り値として返す関数。この関数を戻り値として返す、という意味
    //・val caller: (String) -> String
    // 　callerは「Stringを引数として受け取り、Stringを戻り値として返す関数」を格納した変数
    private fun getTextClosure(suffix: String): (String) -> String {
        val caller: (String) -> String = fun(name: String) = name + suffix
        return caller
    }

    //上記の関数を簡潔に書くとこうなる ↓
    fun getTextClosureSimple(suffix: String): (String) -> String {
        return fun(name: String) = name + suffix
    }

    //クロージャと似ているけど違うコード
    fun likeClosureMain() {
        var suffix = ""

        suffix = "さん"
        val c1: (String) -> String = fun(name: String) = name + suffix

        suffix = "くん"
        val c2: (String) -> String = fun(name: String) = name + suffix

        suffix = "ちゃん"
        val c3: (String) -> String = fun(name: String) = name + suffix

        val name1 = c1("タケシ")
        val name2 = c2("タケシ")
        val name3 = c3("タケシ")

        println(name1)
        println(name2)
        println(name3)
    }


    //38.3
    //クロージャを使うと関数の中に値をキャッシュすることができる
    fun closureMain2() {
        //関数オブジェクトのインスタンス（closure）を生成しているので、関数ないのnumの数値データが保持される
        //closure()はどれも同じ関数のインスタンスを参照しているので、numの値がインクリメントされていく。
        val closure = getCountClosure()
        val closure2 = getCountClosure()
        println("クロージャが返した値" + closure())
        println("クロージャが返した値" + closure())
        //closure2はclosureと同じ関数だが、別のインスタンスなので数値のインクリメントは別々になる
        println("クロージャ2が返した値" + closure2())
        println("クロージャ2が返した値" + closure2())
        println("クロージャが返した値" + closure())

        //closure()で呼び出すと関数を実行した結果が返されるが、closureで呼び出すとオブジェクトそのものが出力される
        println("クロージャが返した値 closureで呼び出し" + closure)

        //クロージャを使わずに単純なインクリメントする関数を呼び出した場合
        println("numIncrement()の実行結果"+numIncrement())
        println("numIncrement()の実行結果"+numIncrement())
        println("numIncrement()の実行結果"+numIncrement())
    }

    //クロージャを使ったインクリメント関数
    private fun getCountClosure(): () -> Int {
        var num = 0
        val closure: () -> Int = fun(): Int {
            return num++
        }
        return closure
    }

    //クロージャを使わないインクリメント関数
    private fun numIncrement(): Int {
        var num = 0
        num++
        return num
    }
}