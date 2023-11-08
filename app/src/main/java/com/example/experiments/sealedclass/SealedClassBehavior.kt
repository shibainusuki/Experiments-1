package com.example.experiments.sealedclass

import java.io.File
import javax.sql.DataSource

sealed class Base {
    object SubOne : Base()    // ok
    object SubTwo : Base()    // ok
}

object SubThree : Base()       // ok

//--------------------------＜色を表現する例＞---------------------------

fun selectColor(color: ColorType) {
    when (color) {
        ColorType.RED -> println("赤が選択されました")
        ColorType.GREEN -> println("緑が選択されました")
        ColorType.BLUE -> println("青が選択されました")
    }
}

//enumでRGBを定義することができるが、CMYKも追加したいとなると「RGB」という括りが保てなくなる（分類の規則性が落ちる）
enum class ColorType {
    RED,
    GREEN,
    BLUE
}

sealed class ColorTypeSecond(val colorRes: Int) {

    //それぞれのサブクラスにプロパティを持たせることができる
    object RED : ColorTypeSecond(colorRes = 1)
    object GREEN : ColorTypeSecond(colorRes = 2)
    object BLUE : ColorTypeSecond(colorRes = 3)
}

fun main2(colorTypeSecond: ColorTypeSecond) {
    when (colorTypeSecond) {
        ColorTypeSecond.RED -> println("value is ${colorTypeSecond.colorRes}")
        ColorTypeSecond.GREEN -> println("value is ${colorTypeSecond.colorRes}")
        ColorTypeSecond.BLUE -> println("value is ${colorTypeSecond.colorRes}")
    }
}


sealed class ColorTypeThird() {
    //data class をサブクラスとして定義し、その中にプロパティを持たせれられる。これは大枠の分類の中に細かな分類を持たせるような形で使いやすいかも。
    data class Rgb(val red: Int, val green: Int, val blue: Int, val action: (Int, Int) -> Int) :
        ColorTypeThird()

    data class Cmyk(val cyan: Int, val magenta: Int, val yellow: Int, val keyPlate: Int) :
        ColorTypeThird()

    fun ColorTypeThird.hello(third: ColorTypeThird) = println("1111")
}
//    object RED : ColorTypeThird()
//    object GREEN : ColorTypeThird()
//    object BLUE : ColorTypeThird()

//ColorTypeにはRgbとCmykがあり、それらの色に色の情報（Int）を持たせることができている。

fun main3(value1: Int, value2: Int) {
    val action = fun(value1: Int, value2: Int) = value1 + value2
    val colorTypeThird: ColorTypeThird = ColorTypeThird.Rgb(1, 2, 3, action = action)
    when (colorTypeThird) {
        is ColorTypeThird.Rgb -> {
            println("取得した色は${colorTypeThird.red}")
            colorTypeThird.action
        }
        is ColorTypeThird.Cmyk -> {
            println("取得した色は${colorTypeThird.cyan}")
        }
    }
}

sealed class SealedClass {
    //abstract とすることでサブクラスが強制的にawesomeValueを実装させられる
    abstract val awesomeValue: Int
}

//出席・欠席みたいな感じで２つに別れるが、その後の選択要素は同じ、みたいな時に使えるかも。。
data class A(override val awesomeValue: Int) : SealedClass()
data class B(override val awesomeValue: Int) : SealedClass()


//拡張関数も使えるらしい。いつ使えばいいんだろう。。
fun SealedClass.hello() = println("hello")
val sealedClass: SealedClass = A(99)

fun main4() {
    sealedClass.hello()
}

//-----------------------------------------------------

//参考記事：https://okuzawats.com/blog/kotlin-sealed-class/