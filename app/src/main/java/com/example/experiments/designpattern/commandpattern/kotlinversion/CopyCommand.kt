package com.example.experiments.designpattern.commandpattern.kotlinversion

class CopyCommand : Command {
    override fun execute() {
        println("テキストをコピーします")
    }
}