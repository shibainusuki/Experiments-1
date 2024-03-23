package com.example.experiments.kotlinbasic.interfaceabstract

class InstagramAPI : AbstractAPI() {
    override fun fetchName(): String {
        return "Instagramの"
    }
}