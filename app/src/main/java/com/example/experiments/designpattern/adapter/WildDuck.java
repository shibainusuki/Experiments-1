package com.example.experiments.designpattern.adapter;

public class WildDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("クワー！！");
    }

    @Override
    public void fly() {
        System.out.println("結構長く飛べます");
    }
}
