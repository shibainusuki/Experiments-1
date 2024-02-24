package com.example.experiments.designpattern.commandpattern.unsmartpattern;

public class UnSmartLight implements UnSmartDevice {

    public void lightOn() {
        System.out.println("ライト点けます");
    }

    public void lightOff() {
        System.out.println("ライトを消します");
    }
}
