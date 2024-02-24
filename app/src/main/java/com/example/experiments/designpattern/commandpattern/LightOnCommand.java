package com.example.experiments.designpattern.commandpattern;

/**
 * Lightインスタンスを受け取り、Lightインスタンスのメソッドを呼び出すクラス（execute()する）
 * ただし、具体的に何が実行されているのかは知らない
 */
public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.lightOn();
    }
}
