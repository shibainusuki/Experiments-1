package com.example.experiments.designpattern.commandpattern;

public class RemoteLoader {
    public void initialize() {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("リビングルーム");
        LightOnCommand lightOnCommand = new LightOnCommand(livingRoomLight);
        LightOffCommand lightOffCommand = new LightOffCommand(livingRoomLight);

        remoteControl.setCommand(0, lightOnCommand, lightOffCommand);

        System.out.println( "remoteControlインスタンスの出力:"+ remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
    }
}
