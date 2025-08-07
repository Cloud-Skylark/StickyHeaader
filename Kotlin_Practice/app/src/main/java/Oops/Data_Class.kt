package Oops

data class Data_Class(val name: String, val age: Int) {
    fun x() {
        println("hey cloudy")
    }
}

fun main() {
    val xx = Data_Class("Cloudy", 22)
    println(xx.name)
}
