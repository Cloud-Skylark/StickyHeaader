package Oops

interface Base {
    var id: Int
    var name: String
    fun x()
}

class child : Base {
    override var id: Int = 0
    override var name: String = ""
    constructor(id: Int = 0) {
        println("p construcotr call")
    }
    constructor(id: Int, name: String): this(id) {
        this.id = id
        this.name = name
        println("s construcotr call")
    }
    override fun x() {
        println("id: $id, name: $name")
    }
}



fun main() {
    val child = child(1, "z")
    child.x()
}