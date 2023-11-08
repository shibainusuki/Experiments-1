package com.example.experiments.other

import com.example.experiments.sealedclass.Base

class CanNotImpSealed {

    //sealed classのBaseを実装しようとしても、別のパッケージにあるため実装することができない
    //object SubFifth: Base()
}

