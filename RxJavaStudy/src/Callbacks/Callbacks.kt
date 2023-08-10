package Callbacks

import java.lang.Exception
import kotlin.concurrent.thread

fun main (){
    println("hello from Callbacks.main thread")
    thread {
        println("running in thread ${Thread.currentThread().name}")
        task1 { println("Callbacks.task1 completed on ${Thread.currentThread().name}") }
    }
    thread {
        println("running in thread ${Thread.currentThread().name}")
        task2(object : Result {
            override fun onPush(data: String) {
                println("task 2 : pushed data successfully $data ")
            }

            override fun onComplete() {
                println("task 2 completed on ${Thread.currentThread().name}")
            }

            override fun onError(error: Exception) {
                println("oops there's an error :(!")
            }

        })
    }
}

fun task1(onComplete: () -> Unit){
    println("long running Callbacks.task1")
    Thread.sleep(1000)
    onComplete.invoke()
}

fun task2(result: Result){
    println("long running Callbacks.task2")
    Thread.sleep(1000)
    result.onPush("data1")
    result.onPush("data2")
    result.onPush("data3")
//    result.onError(RuntimeException("dummy runtime exception!!"))
    result.onComplete()
}