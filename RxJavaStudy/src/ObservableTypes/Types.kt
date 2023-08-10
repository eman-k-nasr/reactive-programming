package ObservableTypes

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

fun main(){
    singleObservable()
    maybeObservable()
    completableObservable()
}

fun singleObservable() {
    Single
        .just("Data is emitted one time")
        .subscribe({
            println("on success : ${it}")
        }, {
            println("on error : ${it.message}")
        })
}

fun maybeObservable(){
    //firstElement method returns Maybe(0 or 1 emission)
    Observable.just("event1","event2").firstElement().subscribe({
        println("maybe1 $it")
    }, {
        println("maybe1 ${it.message}")
    }, {
        println("maybe1 on complete!")
    })

    Observable.empty<String>().firstElement().subscribe({
        println("maybe2 $it")
    }, {
        println("maybe2 ${it.message}")
    }, {
        println("maybe2 on complete!")
    })

    Maybe.just("eman").subscribe {
        println(it)
    }
}

fun completableObservable(){
    //it doesn't emit anything what matters if the action is executed or not
    Completable.complete().subscribe { println("completed") }
}