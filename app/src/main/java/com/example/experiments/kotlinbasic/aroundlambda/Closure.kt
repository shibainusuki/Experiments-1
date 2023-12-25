package com.example.experiments.kotlinbasic.aroundlambda

class Closure {
    //やさしいKotlin入門 38章 クロージャ
    //NOTE クロージャとは:関数オブジェクトを作った時点での情報を関数オブジェクトの中にずっと保管しておくことができる、というもの
    fun closureMain() {
        //getTextClosure() はStringを引数として受け取り、Stringを戻り値として返す関数を返す関数（ややこしい）なので、
        // closure1はStringを引数として受け取り、Stringを戻り値として返す関数を格納している
        val closure1 = getTextClosure("さん")
        val closure2 = getTextClosure("くん")
        val closure3 = getTextClosure("ちゃん")

        //closure1は fun(name: String) = name + suffix という関数のこと。
        //getTextClosure("さん")でsuffixとして"さん"が渡されると、
        //fun(name: String) = name + "さん"という状態で関数オブジェクトがclosure1に格納される。
        //なので、 closure1("タケシ")という形で呼び出すと、"タケシ" + ”さん”というStringが戻り値として返される。
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
    //この場合はsuffixがその都度上書きされるので、printlnでは最後に代入された”ちゃん”が適用されて出力される。
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
        println("numIncrement()の実行結果" + numIncrement())
        println("numIncrement()の実行結果" + numIncrement())
        println("numIncrement()の実行結果" + numIncrement())
    }

    //クロージャを使ったインクリメント関数
    //numは関数オブジェクト（closure）の中に格納され、値が保持された状態になる。
    //そのため、getCountを呼び出すたびにnumは1つずつインクリメントされる。（getCountを同じインスタンスとして呼び出した場合の話）
    private fun getCountClosure(): () -> Int {
        var num = 0
        val closure: () -> Int = fun(): Int {
            return num++
        }
        return closure
    }

    //クロージャを使わないインクリメント関数
    //クロージャを使わないので、何度呼び出されてもnumは0から始まり、1が戻り値として返される。
    private fun numIncrement(): Int {
        var num = 0
        num++
        return num
    }

    fun incrementNum(): () -> Int {
        var number = 0

        return fun(): Int {
            number += 1
            return number
        }
    }

    fun incrementNumFailed(): Int {
        var number = 0
        number += 1
        return number
    }
}