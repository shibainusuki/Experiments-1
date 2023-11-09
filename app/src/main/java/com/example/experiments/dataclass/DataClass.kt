package com.example.experiments.dataclass

class DataClass() {

    data class DataClass(
        val id: Int,
        val token: String,
        val age: Int
    )

    class Normal(
        val id: Int,
        val token: String,
        val age: Int
    )


    fun showDataClassBehavior() {
        val data1 = DataClass(5678, "ze4913oqmg55", 16)
        val data2 = DataClass(5678, "ze4913oqmg55", 15)

        val data1HashCode = data1.hashCode()
        val data2HashCode = data2.hashCode()

        println("@DataClass data1HashCode: $data1HashCode data2HashCode: $data2HashCode")

        if (data1 == data2) {
            println("showDataClassBehavior() 二つは同じものです")
        } else {
            println("showDataClassBehavior() 二つは別のものです")
        }

        println("テスト data1:$data1")

    }

    fun showNormalClassBehavior() {
        val normal1 = Normal(1234, "we435bkos94", 34)
        val normal2 = Normal(1234, "we435bkos94", 34)

        val data1HashCode = normal1.hashCode()
        val data2HashCode = normal2.hashCode()

        println("@Data data1HashCode: $data1HashCode data2HashCode: $data2HashCode")

        if (normal1 == normal2) {
            println("showNormalClassBehavior() 二つは同じものです")
        } else {
            println("showNormalClassBehavior() 二つは別のものです")
        }
        println("テスト $normal1")
    }
}