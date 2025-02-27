package com.lyh.day12

class HelloWorld {
    fun doSomething() {
        println("Hello World")
    }
}
fun main() {
    HelloWorld().doSomething()
    val a = 1
    val b = a
    println("a=$a, b=$b")
    println(a == b)
}