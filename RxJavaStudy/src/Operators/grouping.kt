package Operators

import io.reactivex.rxjava3.core.Observable

fun main(){
    groupBy()
}

fun groupBy(){
    val src = Observable.just("eman","sara","ebrahim","alaa","ayman","salma","samir")
    src.groupBy {
        it.first()
    }.flatMapSingle {
        it.toList()
    }.subscribe{
        println(it)
    }
}