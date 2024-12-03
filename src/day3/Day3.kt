package day3

import java.io.File

fun findMulSequences(input: String, isFirstTask: Boolean = true): Int{
    val mulRegex = """(?i)mul\s*\(\s*([\d*!]+)\s*,\s*([\d*!]+)\s*\)""".toRegex()
    val doRegex = """do\(\)""".toRegex()
    val dontRegex = """don't\(\)""".toRegex()

    val commands = mutableListOf<Pair<String, Pair<Int, Int>?>>()

    val matches = mutableListOf<MatchResult>()

    matches.addAll(mulRegex.findAll(input))
    matches.addAll(doRegex.findAll(input))
    matches.addAll(dontRegex.findAll(input))

    matches.sortBy { it.range.first }

    for (match in matches) {
        when {
            mulRegex.matches(match.value) -> {
                val groups = mulRegex.matchEntire(match.value)!!.groupValues
                val x = groups[1].toInt()
                val y = groups[2].toInt()
                commands.add("mul" to Pair(x, y))
            }
            doRegex.matches(match.value) -> {
                commands.add("do" to null)
            }
            dontRegex.matches(match.value) -> {
                commands.add("don't" to null)
            }
        }
    }

    var canMultiply = true
    var total = 0

    for (command in commands) {
        when (command.first) {
            "do" -> canMultiply = true
            "don't" -> canMultiply = isFirstTask
            "mul" -> {
                if (canMultiply && command.second != null) {
                    total += command.second!!.first * command.second!!.second
                }
            }
        }
    }

   return total
}


fun main() {
    val input = File("src/day3/Task3_input.txt").readLines()
    println(findMulSequences(input.toString()))
    println(findMulSequences(input.toString(), false))
}