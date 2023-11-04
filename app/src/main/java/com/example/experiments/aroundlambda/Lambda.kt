package com.example.experiments.aroundlambda

class Lambda {
    fun lambdaMain() {
        severalTypeLambda()
    }

    private fun severalTypeLambda() {

        //NOTE function1~4は全て同じ意味の関数

        val function1: (String) -> String = fun(x: String): String {
            return x + "ちゃん"
        }

        // これが一番わかりやすいと思うのだが。。
        val function2: (String) -> String = fun(x: String) = x + "ちゃん"

        val function3: (String) -> String = { x -> x + "ちゃん" }

        //itって何？ってなることが度々あるのだが、「関数に渡される引数のこと」と解釈すれば良さそう。
        val function4: (String) -> String = { it + "ちゃん" }

        val result1 = function1("タケシ")
        val result2 = function2("タケシ")
        val result3 = function3("タケシ")
        val result4 = function4("タケシ")

        println(result1)
        println(result2)
        println(result3)
        println(result4)
    }
}