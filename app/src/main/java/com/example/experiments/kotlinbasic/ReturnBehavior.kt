package com.example.experiments.kotlinbasic

import java.lang.Exception

class ReturnBehavior {
    fun inTryCatch() {
        val intNum = 1234
        try {
           println(intNum.toString())
        } catch (e: Exception) {
            println("")
        }
    }
}