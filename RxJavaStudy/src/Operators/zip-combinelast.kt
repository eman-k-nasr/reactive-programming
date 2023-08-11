package Operators

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

fun main(){
 zip()
// combineLatest()
 Thread.sleep(10000)
}

fun zip(){
    val src1 = Observable.interval(500,TimeUnit.MILLISECONDS).take(5)
    val src2 = Observable.interval(2,TimeUnit.SECONDS).take(5)

    src1.subscribe { println("src1 emitted value: $it") }
    src2.subscribe { println("src2 emitted value: $it") }

    Observable
        .zip(src1,src2,{e1,e2 ->
            "src1:$e1,src2:$e2 --> [$e1&$e2]"}
        )
        .subscribe{
            println(it)
        }

    //in zip although src1 is faster but it waits for src2 emission and then combine pairs
    //zip emits items only when each of the zipped source Observables have emitted a previously unzipped item
}

fun combineLatest(){
    val src1 = Observable.interval(500,TimeUnit.MILLISECONDS).take(5)
    val src2 = Observable.interval(2,TimeUnit.SECONDS).take(5)

    src1.subscribe { println("src1 emitted value: $it") }
    src2.subscribe { println("src2 emitted value: $it") }

    Observable
        .combineLatest(src1,src2,{e1,e2 ->
            "src1:$e1,src2:$e2 --> [$e1&$e2]"}
        )
        .subscribe{
            println(it)
        }

    //CombineLatest emits an item whenever any of the source Observables emits an item (so long as each of the source Observables has emitted at least one item).

    //in this example, src1 is more faster it emitted 0,1,2 while src 2 hasn't yet emitted anything
    //when src2 starts to emit 0 src1 already has emitted 3 so it will skip 3 previously emitted values (0,1,2) --> will combine [3,0],
    //src1 will emit 4 while src1 hasn't emitted a new value yet other than 0
    //so,it will combine the last cached one (0) with the new emitted (4)
}