package HelloRxJava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

fun main(){
    val source = Observable.create<String> { emitter ->
        println("inside observable")
        emitter.onNext("Hello")
        emitter.onNext("RxJava")
        emitter.onComplete()
    }
    source.subscribe { println("subscriber 1 $it") }
    source.subscribe { println("subscriber 2 $it") }

    val observer = object : Observer<String>{
        override fun onSubscribe(d: Disposable?) {
            println("subscriber 3 just subscribed now!")
        }

        override fun onNext(t: String?) {
            println("subscriber3 onNext: $t")
        }

        override fun onError(e: Throwable?) {
            println("subscriber3 onError: ${e?.message}")
        }

        override fun onComplete() {
            println("subscriber3 onComplete (no events to be emitted)")
        }

    }

    source.safeSubscribe(observer)

    val justSource = Observable.just(1,2,3,4)
    justSource.subscribe { println(it) }
    justSource.subscribe({ print("$it ")},{ print(it.message)})

    val fromIterableSource = Observable.fromIterable(arrayListOf("one","two","three"))
    fromIterableSource.subscribe { print("$it ")}
}