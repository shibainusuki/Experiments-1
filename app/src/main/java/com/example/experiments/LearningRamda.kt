package com.example.experiments

//やさしいKotlin入門37章に載っているコード

//37.2

class LearningRamda {
    companion object {
        fun main(/*args: Array<String>*/) {
            //calculatePlus()を変数に代入している
            //val plusCalculationFunction = ::calculatePlus
            //calculateMinus() を変数に代入している
            //val minusCalculationFunction = ::calculateMinus
            printRandomValuesCalculation(plusCalculationFunction)
            printRandomValuesCalculation(minusCalculationFunction)
        }
        private val plusCalculationFunction = fun(x: Double, y: Double): Double = x + y
        private val minusCalculationFunction = fun(x: Double, y: Double): Double = x - y

        private fun printRandomValuesCalculation(calculator: (Double, Double) -> Double) {
            val x = Math.random()
            val y = Math.random()
            val result = calculator(x, y)
            println("計算結果は${result}です")
        }
    }

    //様々な無名関数の書き方
    val p1 = fun(x: Double, y: Double) = x + y
    val p2 = fun(x: Double, y: Double): Double = x + y
    val p3 = fun(x: Double, y: Double): Double {
        return x + y
    }

    //これはかなり冗長な書き方な気がする。。
    val p4: (Double, Double) -> Double = fun(x: Double, y: Double): Double {
        return x + y
    }

    val p5: (Double, Double) -> Double = fun(x, y) = x + y
}