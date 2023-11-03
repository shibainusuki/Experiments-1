package com.example.experiments

//やさしいKotlin入門37章に載っているコード

//37.2

class LearningRamda {
    companion object {
        fun main(/*args: Array<String>*/) {
            //calculatePlus()を変数に代入している
            val plusCalculationFunction = ::calculatePlus
            //calculateMinus() を変数に代入している
            val minusCalculationFunction = ::calculateMinus
            printRandomValuesCalculation(plusCalculationFunction)
            printRandomValuesCalculation(minusCalculationFunction)
        }

         fun calculatePlus(x: Double, y: Double) = x + y
        fun calculateMinus(x: Double, y: Double) = x - y

        fun printRandomValuesCalculation(calculator: (Double, Double) -> Double) {
            val x = Math.random()
            val y = Math.random()
            val result = calculator(x, y)
            println("計算結果は${result}です")
        }
    }
}



