package ru.galuzin.kotlinsamples

import ru.galuzin.kotlinsamples.TimeInterval

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = addTimeIntervals(timeInterval,1)

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)

operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this,number)

operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval): MyDate = addTimeIntervals(repeatedTimeInterval.timeInterval,repeatedTimeInterval.number)

fun task1(today: MyDate): MyDate {
    return today + TimeInterval.YEAR + TimeInterval.WEEK
}

fun task2(today: MyDate): MyDate {
    return today + TimeInterval.YEAR * 2 + TimeInterval.WEEK * 3 + TimeInterval.DAY * 5
}
