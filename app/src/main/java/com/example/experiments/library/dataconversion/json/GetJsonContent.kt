package com.example.experiments.library.dataconversion.json

import org.json.JSONObject

class GetJsonContent {

    /**
     * JSONオブジェクトを生成する
     *
     * @return JSONオブジェクト
     */
    private fun createJson(): JSONObject {
        return JSONObject().let {
            it.put("userName", "Tanaka")
            it.put("id", 123456)
            it.put("JSON_OBJECT", createJsonFromInt(100))
        }
    }

    private fun createJsonFromInt(num: Int): JSONObject {
        return JSONObject().put("number", num)
    }

    fun extractUserNameFormJson(name: String) {
        val jsonObject = createJson()
        try {
            //指定したnameに設定されているvalueを取得する。
            //この時、nameが存在しない場合はnullが返却される。
            val extractedOptJsonObject = jsonObject.optJSONObject(name)
            println("name:$name extractedOptJsonObject is $extractedOptJsonObject")

            //出力結果
            //name:userName extractedOptJsonObject is null
            //name:id extractedOptJsonObject is null
            //name:JSON_OBJECT extractedOptJsonObject is {"number":100}
            //name:hogehoge extractedOptJsonObject is null

        } catch (exception: Throwable) {
            println("$name is $exception")
        }
        try {
            //指定したnameに設定されているvalueを取得する。
            //この時、nameが存在しない場合は空文字が返却される。
            val extractedFromOptString = jsonObject.optString(name)
            println("name:$name extractedFromOptString is $extractedFromOptString")

            //出力結果
            //name:userName extractedFromOptString is Tanaka
            //name:id extractedFromOptString is 123456
            //name:JSON_OBJECT extractedFromOptString is {"number":100}
            //name:hogehoge extractedFromOptString is

        } catch (exception: Throwable) {
            println("$name is $exception")
        }
        try {
            //指定したnameに設定されているvalueを取得する。
            //この時、nameが存在しない場合やvalueがString型ではない場合はJSONExceptionがスローされる。

            val extractedFromGetString = jsonObject.getString(name)
            println("name:$name extractedFromGetString is $extractedFromGetString")

            //出力結果
            //name:userName extractedFromOptString is Tanaka
            //name:id extractedFromOptString is 123456
            //name:JSON_OBJECT extractedFromOptString is {"number":100}

        } catch (exception: Throwable) {
            println("$name is $exception")
            //hogehoge is org.json.JSONException: No value for hogehoge
        }
        try {

            //指定したnameに設定されているvalueを取得する。
            //この時、nameが存在しない場合やvalueがオブジェクトではない場合はJSONExceptionがスローされる。

            val extractFromGetJsonObject = jsonObject.getJSONObject(name)
            println("name:$name extractFromGetJsonObject is $extractFromGetJsonObject")

            //出力結果
            //name:JSON_OBJECT extractFromGetJsonObject is {"number":100}

        } catch (exception: Throwable) {
            println("$name is $exception")
            //userName is org.json.JSONException: Value Tanaka at userName of type java.lang.String cannot be converted to JSONObject
            //id is org.json.JSONException: Value 123456 at id of type java.lang.Integer cannot be converted to JSONObject
            // hogehoge is org.json.JSONException: No value for hogehoge
        }
    }
}