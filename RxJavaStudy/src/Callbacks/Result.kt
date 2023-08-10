package Callbacks

import java.lang.Exception

interface Result {
    fun onPush(data: String)
    fun onComplete()
    fun onError(error: Exception)
}