package com.example.experiments.either

class Either {
    sealed class Either<out A, out B> {
        //Eitherはプロジェクトの中の色々な場面で使われることを想定している
        //なので型がA,Bのようにジェネルクスになっているのだろう。。
        data class Left<out A, out B>(val value: A) : Either<A, B>()
        data class Right<out A, out B>(val value: B) : Either<A, B>()
    }

    private fun divide(a: Int, b: Int): Either<String, Double> {
        return if (b == 0) {
            Either.Left("Division by zero")
        } else {
            Either.Right(a.toDouble() / b)
        }
    }

    /**
     * divideに渡される値によってresultに入るeitherが変わる
     */
    fun main() {
        val result1 = divide(6, 3)
        when (result1) {
            is Either.Left -> println("Error: ${result1.value}")
            is Either.Right -> println("Result: ${result1.value}")
        }

        val result2 = divide(6, 0)
        when (result2) {
            is Either.Left -> println("Error: ${result2.value}")
            is Either.Right -> println("Result: ${result2.value}")
        }
    }
}