package com.example.experiments.designpattern.commandpattern;

/**
 * リモコンクラス
 * ・OnとOffのコマンドを入れるための配列を生成している。
 * ・デフォルトでは配列にはNoCommandインスタンスが格納されている。
 * ・SetCommandメソッドで指定したスロットにコマンドを設定することができる。
 * ・ただし、なんのクラスのコマンドなのかは知らない（リビングライトのコマンドなのか、ガレージのシャッターのコマンドなのかなど）
 */
public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {
        //ONコマンドが7こ入る配列を作成する。
        onCommands = new Command[7];
        //OFFコマンドが7こ入る配列を作成する。
        offCommands = new Command[7];

        //何も実行しないNoCommendインスタンスを生成し
        //配列に格納する
        //疑問　一つのインスタンスを別々の配列のインデックスに入れてるが、これって意味あるのか。。？
        //→何もコマンドがない、ということが表現できればそれでいい。なので同じインスタンスで問題なし
        NoCommand noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot){
        offCommands[slot].execute();
    }


}
