package com.example.experiments.sealedclass

class CanIMpSealed {
    //別ファイルに定義されているが、同じパッケージ内なのでsealed classを実装できる
    object SubFour: Base()
}