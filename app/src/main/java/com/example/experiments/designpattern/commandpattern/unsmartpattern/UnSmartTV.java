package com.example.experiments.designpattern.commandpattern.unsmartpattern;

public class UnSmartTV implements UnSmartDevice {
    public void tvOn() {
        System.out.println("テレビの電源を点けます");
    }

    public void tvOff() {
        System.out.println("テレビの電源を消します");
    }
}
