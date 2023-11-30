package com.example.experiments.kotlinbasic.generics

class Generics {
    class Box<E, T> {
        private var element: E? = null
        private var content: T? = null

        fun setValues(element: E, content: T) {
            this.element = element
            this.content = content
        }

        fun compareProperties(): Boolean {
            return (this.element == this.content)
        }

//基本的にジェネリクス型（何でも入り得る型）のプロパティは演算、比較はできないようになっているっぽい。
// ただし==での比較はできる。

        //エラーになる。＞が認められない
//        fun compareProperties2():Boolean{
//            return (this.element > this.content)
//        }


        //エラーになる。+が認められない
//        fun sumProperties():Int{
//            return (this.element + this.content)
//        }


        //エラーになる。+が認められない
//        fun sumProperties(): String {
//            return (this.element + this.content)
//        }
    }

    fun initBox() {
        val box = Box<String, Int>()
        box.setValues("100", 100)
        val isSame = box.compareProperties()
        println("テスト isSame: $isSame")
    }
}