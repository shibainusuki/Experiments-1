package com.example.experiments.designpattern.commandpattern.kotlinversion

class TextEditor {
    private val commands = arrayListOf<Command>()

   fun initCommand() {
        commands.let {
            it.add(InsertCommand())
            it.add(DeleteCommand())
            it.add(CopyCommand())
        }
    }

    fun executeCommand(index: Int) {
        commands[index].execute()
    }

    fun execute(command: Command){
        command.execute()
    }
}