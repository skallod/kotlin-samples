package ru.galuzin.kotlinsamples.properties

const val v1 = "good"

data class PropertyData (val quantity: Int)

class PropertyExample() {

    var counter = 0

    var propertyWithCounter: Int? = null
        set(value) {
            field = value
            counter++
        }

    lateinit var li1: PropertyData

    fun init(){
        li1 = PropertyData(11)
    }
}
