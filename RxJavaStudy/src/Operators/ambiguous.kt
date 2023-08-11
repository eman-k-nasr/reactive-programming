package Operators

import io.reactivex.rxjava3.core.Observable
import java.util.*
import java.util.concurrent.TimeUnit

fun main(){
    amb()
    Thread.sleep(11000)
}

fun amb(){
    val src1 = Observable.interval(1,TimeUnit.SECONDS).map { "src1 : $it" }.take(10)
    val src2 = Observable.interval(10,TimeUnit.MILLISECONDS).map { "src2 : $it" }.take(10)
    Observable
        .amb(Arrays.asList(src1,src2))
        .subscribe{
            println(it)
        }

}