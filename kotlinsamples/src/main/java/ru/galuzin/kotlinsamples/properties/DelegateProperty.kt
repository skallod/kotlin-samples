package ru.galuzin.kotlinsamples.properties

class DelegateProperty(val initalizer:() -> Int){
    val lazyV : Int by lazy (initalizer )
}
