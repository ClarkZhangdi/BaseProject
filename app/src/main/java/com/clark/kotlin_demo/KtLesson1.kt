package com.clark.kotlin_demo

/**
 *  Created By Clark
 *  Description :学习kotlin 第一天
 *  @date 2019/5/20.
 *  类型推断
 */

fun main() {
//    println("Hello World")
//    println(doubleX(age))
//    println(name)
//    javaCompareKT.age=12
//    println(javaCompareKT.age)
    javaCompareKT.doWhatever()
    javaCompareKT.toString()
}

fun doubleX(i: Int): Int {
    return i * 2
}

var age: Int = 18
const val name: String = "liu de hua"
var javaCompareKT = JavaCompareKT()
/*兼容性 保护性的东西*/