package ru.galuzin.kotlinsamples

import ru.galuzin.kotlinsamples.collections.*
import java.lang.RuntimeException
import java.util.*
import kotlin.Comparator

fun main(){
//    val invokable = Invokable()
//    invokeTwice(invokable)
//    println("invokes "+invokable.numberOfInvocations)
//    intersectTest();
//    val date = MyDate(2000, 1, 1)
//    val task2 = task2(date)
//    isLeapDay(date)
//    println("task2 = ${task2}")
//    val items = arrayListOf<Int>(1, 2, 3, 4, 5)
//    sort(items)
//    println("r="+items)
    //val forLoop = forLoop()
    val cstmr = shop.findAnyCustomerFrom(City("wer"))?: throw RuntimeException("good")
    println("покупатель $cstmr")
}

fun containsEven(collection: Collection<Int>):Boolean {
    return collection.any({a -> a==1})
}

fun sort(collection: List<Int>) {
     Collections.sort(collection,object : Comparator<Int> {
         override fun compare(x: Int, y: Int) = y - x
     })
}
