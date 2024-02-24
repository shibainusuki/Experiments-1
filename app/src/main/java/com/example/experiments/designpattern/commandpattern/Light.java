package com.example.experiments.designpattern.commandpattern;

/**
 * 何を実行するかを把握しているクラス
 */
public class Light {

    String roomPlace;

    public Light(String roomPlace) {
        this.roomPlace = roomPlace;
    }

    public void lightOn() {
        System.out.println(roomPlace + "のライトがオンになりました");
    }

    public void lightOff() {
        System.out.println(roomPlace + "ライトがオフになりました");
    }
}
