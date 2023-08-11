package Operators

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

fun main(){
    filter()
    map()
    reduce()
}

fun filter(){
    //filter is considered to be a suppressing operator
    //other supress operators: take,skip,distinct,
    Observable.just(10,23,33,40,55,60)
        .filter {
            println("$it % 2 is equal zero ? ${it % 2 == 0}")
            it %2 == 0
        }.subscribe {
            println("so,forward $it")
        }
}

fun map(){
    //map is considered to be a transforming operator
    //other transform operators: cast,delay,scan,sorted,...
    Observable.just("eman","sara","noha")
        .map {
            println("do transformation on $it")
            "Hello $it !!"
        }.subscribe{
            println(it)
        }
}

fun reduce(){
    //reduce is considered to be a reducing operator
    //other reducing operators :count,all,any,contains,collect,toMap,..
    Observable.just(1,2,3,4)
        .reduce { t1, t2 ->
            println("$t1 + $t2 = ${t1+t2}")
            t1+t2
        }.subscribe {
            println("final total: $it")
        }

}

