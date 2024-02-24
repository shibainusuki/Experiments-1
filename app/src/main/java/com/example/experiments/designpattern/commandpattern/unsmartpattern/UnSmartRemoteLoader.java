package com.example.experiments.designpattern.commandpattern.unsmartpattern;

import com.example.experiments.designpattern.commandpattern.UnSmartRemoteControl;

public class UnSmartRemoteLoader {
    UnSmartRemoteControl unSmartRemoteControl = new UnSmartRemoteControl();
    UnSmartNoDevice unSmartNoDevice = new UnSmartNoDevice();

    public void initialize() {
        unSmartRemoteControl.setDevice(0, new UnSmartLight());
        unSmartRemoteControl.setDevice(1, new UnSmartTV());
        unSmartRemoteControl.setDevice(2, unSmartNoDevice);
        unSmartRemoteControl.setDevice(3, unSmartNoDevice);
        unSmartRemoteControl.setDevice(4, unSmartNoDevice);
        unSmartRemoteControl.setDevice(5, unSmartNoDevice);
        unSmartRemoteControl.setDevice(6, unSmartNoDevice);
    }
}
