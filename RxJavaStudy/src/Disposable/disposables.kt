package Disposable

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

fun main(){
    val disposables = CompositeDisposable()
    //unbounded observable
    val src = Observable.interval(1,TimeUnit.SECONDS)
    val d1  = src.subscribe{
        println("subscriber 1 : $it")
    }

    val d2 = src.subscribe {
        println("subscriber 2 : $it")
    }

    val d3 = src.subscribe {
        println("subscriber 3 : $it")
    }

    Thread.sleep(5000)

    //subscriber1,2 don't want to subscribe anymore to the source
    disposables.addAll(d1,d2)
    disposables.dispose()

    Thread.sleep(10000)
}