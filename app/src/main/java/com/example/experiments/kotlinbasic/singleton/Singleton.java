package com.example.experiments.kotlinbasic.singleton;


public class Singleton {

    //プライベートなインスタンスを生成しておく
    private static Singleton instance;

    private Singleton() {
        //空のコンストラクタ
        //外からnew Singleton()できないようにprivateとして定義しておく。
    }

    //Singleton.getInstance(）という形でインスタンスを呼び出す。
    //インスタンスが生成されていない場合のみインスタンスが生成される。
    //２回目以降は生成されないので、インスタンスが複数できることは基本的にはない
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
