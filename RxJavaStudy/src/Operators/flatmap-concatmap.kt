package Operators

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

fun main(){
    flatMap()
//    concatMap()
    Thread.sleep(10000)
}

fun flatMap(){
    Observable.fromIterable(arrayListOf("h.e.l.l.o","r.x","j.a.v.a"))
        .flatMap { item ->
            println("emitted: $item")
            Observable
                .fromIterable(item.split("."))
                 //each emitted item takes 2 seconds to be successfully broken into a new observable
                 //the advantage of flat map it doesn't have to wait 2 seconds until second emission
                .delay(2, TimeUnit.SECONDS)
    }.subscribe {
        println("recieved $it")
    }
}

fun concatMap(){
    Observable.fromIterable(arrayListOf("h.e.l.l.o","r.x","j.a.v.a"))
        .concatMap { item ->
            println("emitted: $item")
            Observable
                .fromIterable(item.split("."))
                //each emitted item takes 2 seconds to be successfully broken into a new observable
                //it can't emit next item until each previous item is broken into new observable unlike flat map
                .delay(2, TimeUnit.SECONDS)
        }.subscribe {
            println("recieved $it")
        }
}


