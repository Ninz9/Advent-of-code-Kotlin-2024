package day1

import java.io.File
import kotlin.math.abs

fun main() {
    val input = File("src/day1/Task1_input.txt").readLines().toString().replace("[", "").replace("]", "").split(",")

    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()

    input.forEach { line ->
        val (col1, col2) = line.split("   ").map {
            it.trim().toInt()
        }
        list1.add(col1)
        list2.add(col2)
    }

    list1.sort()
    list2.sort()

    var part1res = 0

    for (i in 0..list1.size - 1 ) {
        part1res += abs(list1[i] - list2[i])
    }

    println(">$part1res")


    val set1 = list1.toSet()

    var part2res = 0

    set1.forEach {
        part2res += it * list2.count { it2 -> it2 == it }
    }

    println(">$part2res")


}