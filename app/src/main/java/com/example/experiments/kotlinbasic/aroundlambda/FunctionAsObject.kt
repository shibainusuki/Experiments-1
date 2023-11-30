package com.example.experiments.kotlinbasic.aroundlambda

//やさしいKotlin入門37章に載っているコード

//37.2

class FunctionAsObject {
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

        fun showCalculateResult() {
            //関数を戻り値として受け取り、変数に格納する
            val calculator1 = callCalculatorFunction("+")
            val calculator2 = callCalculatorFunction("-")

            val result1 = calculator1(10.0,20.0)
            val result2 = calculator2(100.0,300.0)

            println("計算結果は$result1")
            println( "計算結果は$result2")
        }

        /**
         * @param formulaType 計算式のタイプ
         * @return  (x + y) または (x - y)　の計算をする関数を返す
         */
        private fun callCalculatorFunction(formulaType: String): (Double, Double) -> Double {
            val plusCalculator = fun(x: Double, y: Double) = x + y
            val minusCalculator = fun(x: Double, y: Double) = x - y

            val calculator = when (formulaType) {
                "+" -> plusCalculator
                else -> minusCalculator
            }
            return calculator
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