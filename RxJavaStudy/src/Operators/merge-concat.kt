package Operators

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

fun main(){
//    merge()
    concat()
    Thread.sleep(20000)
}

fun merge(){
    //here we get emission concurrently
    val source1 = Observable.interval(1,TimeUnit.SECONDS).map { "source1 : $it" }
    val source2 = Observable.interval(2,TimeUnit.SECONDS).map { "source2 : $it" }
    Observable.merge(source1,source2)
        .subscribe {
            println("Received : $it")
        }
}

fun concat(){
    //here we get emissions sequentially
    val source1 = Observable.interval(1,TimeUnit.SECONDS).map { "source1 : $it" }.take(10)
    val source2 = Observable.interval(1,TimeUnit.SECONDS).map { "source2 : $it" }
    Observable.concat(source1,source2)
        .subscribe {
            println("Received : $it")
        }
}