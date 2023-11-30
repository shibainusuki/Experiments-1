package com.example.experiments.kotlinbasic.other

import com.example.experiments.kotlinbasic.sealedclass.Base

class CanNotImpSealed {

    //sealed classのBaseを実装しようとしても、別のパッケージにあるため実装することができない
    //object SubFifth: Base()
}

