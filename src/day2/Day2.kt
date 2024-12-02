package day2

import java.io.File

fun checkReportFirst(line: List<Int>): Boolean {
    var direction = if (line[0] > line[1]) -1 else 1

    for ((index, value) in line.withIndex()) {
        if (index == 0) continue

        if (direction * (value - line[index-1]) !in 1..3) {
            return false
        }
    }

    return true
}

fun checkReportSecond(line: List<Int>): Boolean {
    var errors = 0
    var direction = if (line[0] > line[1]) -1 else 1

    for ((index, value) in line.withIndex()) {
        if (index == 0) continue

        if (direction * (value - line[index-1]) !in 1..3) {
            errors++
        }
        if (errors == 2){
            return false
        }
    }

    return true
}

fun main() {
    val input = File("src/day2/Task2_input.txt").readLines()

    var res1 = 0
    var res2 = 0

    input.forEach { line ->
        val report = line.split(" ").map { it.toInt() }
        if (checkReportFirst(report)){
            res1++
        }
        if (checkReportSecond(report)){
            res2++
        }
    }

    println(res1)
    println(res2)
}