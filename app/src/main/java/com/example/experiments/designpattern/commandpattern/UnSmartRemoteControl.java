package com.example.experiments.designpattern.commandpattern;

import com.example.experiments.designpattern.commandpattern.unsmartpattern.UnSmartDevice;
import com.example.experiments.designpattern.commandpattern.unsmartpattern.UnSmartLight;
import com.example.experiments.designpattern.commandpattern.unsmartpattern.UnSmartNoDevice;
import com.example.experiments.designpattern.commandpattern.unsmartpattern.UnSmartTV;

public class UnSmartRemoteControl {

   UnSmartDevice[] unSmartDevices;

    public void setDevice(int slot, UnSmartDevice unSmartDevice) {
       unSmartDevices[slot] = unSmartDevice;
    }

    //デバイスごとに実行するメソッド名が異なる、という仕様なのでセットされるデバイスによってメソッドを修正する必要がある。
    //Commandパターンの場合でも追加するクラスを定義する必要はあるが、コントローラー側では常にonCommands[slot].execute();のように呼び出せば良い
    public void onButtonWasPushed(int slot) {
        if (slot == 0) {
            //実行するメソッドが抽象化されていないので、デバイスの変更があるたびにスロット番号とデバイスのメソッドを修正するひつようがある。
            ((UnSmartLight) unSmartDevices[0]).lightOn();
        } else if (slot == 1) {
            ((UnSmartTV) unSmartDevices[1]).tvOn();
        } else {
            //Do Nothing
        }
    }

    public void offButtonWasPushed(int slot) {
        if (slot == 0) {
            ((UnSmartLight) unSmartDevices[0]).lightOff();
        } else if (slot == 1) {
            ((UnSmartTV) unSmartDevices[1]).tvOff();
        } else {
            //Do Nothing
        }
    }
}
