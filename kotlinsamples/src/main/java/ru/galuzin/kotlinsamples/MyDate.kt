package ru.galuzin.kotlinsamples

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int = 1) : Comparable<MyDate>{
    override fun compareTo(other: MyDate): Int = when{
        year!=other.year -> year - other.year
        month!=other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }

}

operator fun MyDate.rangeTo(other: MyDate) = DateRange(this,other)
