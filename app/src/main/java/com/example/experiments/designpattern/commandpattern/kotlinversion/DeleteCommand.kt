package com.example.experiments.designpattern.commandpattern.kotlinversion

class DeleteCommand : Command {
    override fun execute() {
        println("テキストを削除しました")
    }
}