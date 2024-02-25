package com.example.experiments.designpattern.adapter;

public class DuckTestDrive {

    public void initDuckTestDrive() {

       Duck wildDuck = new WildDuck();
       driveDuck(wildDuck);

        Turkey turkey = new Turkey();
        //カモの皮を被らせた（インターフェースを実装させた）ターキーアダプターインスタンスを生成する。
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        driveDuck(turkeyAdapter);
    }

    public void driveDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
