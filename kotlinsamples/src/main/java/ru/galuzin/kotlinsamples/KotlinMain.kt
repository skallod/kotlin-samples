package ru.galuzin.kotlinsamples

import ru.galuzin.kotlinsamples.collections.*
import ru.galuzin.kotlinsamples.step.Step
import ru.galuzin.kotlinsamples.step.StepNormal
import java.lang.RuntimeException
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import kotlin.Comparator

const val DB_TIMEOUT = 3_00

fun main(){

    var str: String? = null
    val bool = str?.length == 0
    println(bool)

    val stepName = StepNormal::class.java.getAnnotation(Step::class.java).name
    println(stepName)

//    for (index in 0 until 0) {
//        println("good")
//    }
//    println("good 2")

//    val setting = 0 - 1
//    val repeat = if (setting < 0) 0 else setting
//    println("repeat $repeat")

//    val repeat2 = (1-0).let { if (it<0) 0 else it }
//    println("repeat2 $repeat2")

//    var dbConnect : Int? = null
//    val dbCstr : String = dbConnect?.toString()?:"600000"
//    println("db conn $dbCstr")

//    val dbTm : String? = "700"
//    val dbInt = safeStrToInt( dbTm , DB_TIMEOUT)
//    println("db tm ${dbInt.toString()}")

//    val invokable = Invokable()
//    invokeTwice(invokable)
//    println("invokes "+invokable.numberOfInvocations)

//    intersectTest();

//    val date = MyDate(2000, 1)
//    println("date = $date")
//    val date2 = MyDate(2000, 1, 2)
//    println("date = $date2")
//    val task2 = task2(date)
//    isLeapDay(date)
//    println("task2 = ${task2}")
//    val items = arrayListOf<Int>(1, 2, 3, 4, 5)
//    sort(items)
//    println("r="+items)
    //val forLoop = forLoop()
//    val cstmr = shop.findAnyCustomerFrom(City("wer"))?: throw RuntimeException("good")
//    println("покупатель $cstmr")
//    val string = "bonne journée"
//    val result = string.associate { char -> char to char.toInt() }
//    println(result) // {b=98, o=111, n=110, e=101,  =32, j=106, u=117, r=114, é=233}
//    val t = temp("good")
//    t.field = result['a']?.toString()?:t.field
//    println(t.field)

//    val test : Int? = null
//    val test1 = test as Int
//    println("$test1")

//    var first = false;
//    val map = ConcurrentHashMap<String, String>()
//    map.computeIfAbsent("token"){ key ->
//        first =true
//        return@computeIfAbsent "value"
//    }
//    println("first $first")
}

data class temp(var field: String?)

fun containsEven(collection: Collection<Int>):Boolean {
    return collection.any({a -> a==1})
}

fun sort(collection: List<Int>) {
     Collections.sort(collection,object : Comparator<Int> {
         override fun compare(x: Int, y: Int) = y - x
     })
}

fun safeStrToInt( str : String?, default :Int) : Int {
    var intFromStr : Int
    try {
        intFromStr = str?.toInt()?:default
    } catch (e : Exception) {
        println("error " + e)
        intFromStr = default
    }
    return intFromStr
}
