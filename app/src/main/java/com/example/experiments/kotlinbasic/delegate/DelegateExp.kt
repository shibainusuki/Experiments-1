package com.example.experiments.kotlinbasic.delegate

class DelegateExp {

    fun initDelegateExp() {
        val dog = Dog("大分県", "マル")
        dog.let {
            it.eat()
            it.sleep()
            it.breath()
        }
        Cat(dog).let {
            it.eat()
            it.sleep()
            it.breath()
        }


    }

    interface Animal {
        fun eat()
        fun sleep()
        fun breath()
    }

    class Dog(val address: String, val name: String) : Animal {
        override fun eat() {
            println("${address}在住の${name}は今日も元気いっぱいごはんを食べます")
        }

        override fun sleep() {
            println("${address}在住の${name}は今日も元気いっぱい眠ります")
        }

        override fun breath() {
            println("${address}在住の${name}は今日も元気いっぱい呼吸します")
        }
    }

    class Cat(val dog: Dog) : Animal by dog {
        val age = dog.address
        val name = dog.name
        override fun eat() {
            dog.eat()
        }

        override fun sleep() {
            dog.sleep()
        }

        override fun breath() {
            dog.breath()
        }
    }
}