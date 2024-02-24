package com.example.experiments.designpattern.commandpattern;

/**
 * 何も行わないことを明示しているクラス
 * Commandインターフェースを実装しているが、execute()で実行する内容はからっぽ。
 */
public class NoCommand implements Command {
    @Override
    public void execute() {
        //Do Nothing
    }
}
