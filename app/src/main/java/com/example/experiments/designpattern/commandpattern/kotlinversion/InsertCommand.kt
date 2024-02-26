package com.example.experiments.designpattern.commandpattern.kotlinversion

class InsertCommand : Command {
    override fun execute() {
        println("テキストを挿入します")
    }
}