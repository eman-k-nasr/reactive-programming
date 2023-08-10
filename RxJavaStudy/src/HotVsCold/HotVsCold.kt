package HotVsCold

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

fun main(){
    simulateColdObservable()
    simulateHotObservable()
}

fun simulateHotObservable(){
    val source = Observable.interval(1,TimeUnit.SECONDS).publish()
    source.connect()
    source.subscribe { println("subscriber1 : $it") }
    Thread.sleep(3000)
    source.subscribe { println("subscriber2 : $it") }
    Thread.sleep(6000)
    source.subscribe { println("subscriber3 : $it") }
    Thread.sleep(1000)
}

fun simulateColdObservable(){
    var list = arrayListOf(1,2,3)
    val obs = Observable.fromIterable(list)
    println("subscriber 1 is about to recieve data ..")
    obs.subscribe { print ("$it ")}
    println()
    list = getData(list)
    println("subscriber 2 is about to recieve data after data source is modified ..")
    obs.subscribe { print ("$it ")}
}

fun getData(list:ArrayList<Int>): ArrayList<Int> {
    list.add(4)
    return list
}