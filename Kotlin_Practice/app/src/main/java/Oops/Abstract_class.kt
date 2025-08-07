package Oops

abstract class Vehicle {
    abstract var brand: String
    abstract var speed: String

    abstract fun displayInfo()
}

class Car : Vehicle() {
    override var brand: String = "" // Initialize here
    override var speed: String = "" // Initialize here

    fun set(b: String, s: String) {
        this.brand = b
        this.speed = s
    }

    override fun displayInfo() {
        println("Car: $brand, $speed")
    }
}

fun main() {
    val x = Car()
//    x.set("Toyota", "180 km/h")  // Set values
    x.displayInfo()               // Call displayInfo after setting values
}
