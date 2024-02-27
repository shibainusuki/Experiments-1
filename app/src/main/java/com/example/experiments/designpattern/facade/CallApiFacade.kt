package com.example.experiments.designpattern.facade

/*class CallApiFacade<T> {
    *//**      * Retrofit を使った API 実行の窓口      *      * - 通信処理におけるカスタム Exception を作成      *      * @param command Retrofit の通信処理が実装されたラムダ式      * @return command の実行結果      *//*
    @Throws(
        jp.xxx.zzz_android.app_core.exceptions.HttpException::class,
        TimeoutException::class,
        CoreException::class
    )
    suspend fun execute(command: suspend () -> T): T {
        try {
            return command()
        } catch (exception: Exception) {
            when (exception) {
                is HttpException -> {
                    throw createHttpException(exception)
                }

                is java.net.ConnectException, is java.net.UnknownHostException, is SocketTimeoutException -> {
                    throw TimeoutException(message = exception.message ?: "")
                }

                else -> {
                    throw CoreException(message = exception.message ?: "")
                }
            }
        }
    }
}*/
