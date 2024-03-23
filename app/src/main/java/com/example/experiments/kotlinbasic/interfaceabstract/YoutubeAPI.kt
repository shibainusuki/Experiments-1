package com.example.experiments.kotlinbasic.interfaceabstract

class YoutubeAPI: AbstractAPI() {
    override fun fetchName(): String {
       return "YouTubeの"
    }
}