package com.example.experiments.extendedfunction

class ExtendedFunction {
    fun main() {
        val text = "勉強"
        val message = text.getOneTwoFiveMessage()
        println(message)

        val age1 = 25
        val age2 = 17

        age1.isUnder20()
        age2.isUnder20()
    }

    //Finalのため実装できないStringの後に、getOneTwoFiveMessage()のように関数を定義することで、
    // Stringクラスの中にgetOneTwoFiveMessage()があるかのような使い方ができる。
    private fun String.getOneTwoFiveMessage() = "一に${this},二に${this}、三、四がなくて五に${this}"

    // 以下のようにString（）を実装しようとすると「This type is final, so it cannot be inherited from」というエラーが出る
    //なぜならString(）はfinalで定義されているので、Stringを実装することはできないから。。

//    class MyString(a: String) : String(a) {
//        fun getOneTwoFiveMessage() = "一に${this},二に${this}、三、四がなくて五に${this}"
//    }

    /**
     * Intを拡張した関数
     *
     */
    private fun Int.isUnder20() {
        if (this < 20) {
            println("${this}歳の方はお酒の購入はできません")
        } else {
            println("ご購入ありがとうございます！")
        }
    }
}