package day4

import java.io.File


fun getVertical(input: List<String>, i: Int, j: Int): Int{
    var res = 0

    if (i - 3 >= 0 ) {
        val str = "" + input[i][j] + input[i-1][j] + input[i-2][j] + input[i-3][j]
        if (str == "XMAS")
            res += 1
    }

    if (i + 3 < input.size) {
        val str = "" + input[i][j] + input[i+1][j] + input[i+2][j] + input[i+3][j]
        if (str == "XMAS")
            res += 1
    }

    return res
}

fun getHorizontal(input: List<String>, i: Int, j: Int): Int{
    var res = 0

    if (j - 3 >= 0) {
        val str = "" + input[i][j] + input[i][j-1] + input[i][j-2] + input[i][j-3]
        if (str == "XMAS")
            res += 1
    }

    if (j + 3 < input[i].length) {
        val str = "" + input[i][j] + input[i][j+1] + input[i][j+2] + input[i][j+3]
        if (str == "XMAS")
            res += 1
    }

    return res
}

fun getDiagonal(input: List<String>, i: Int, j: Int): Int {
    var res = 0

    if (i - 3 >= 0 && j - 3 >= 0) {
        val str = "" + input[i][j] + input[i-1][j-1] + input[i-2][j-2] + input[i-3][j-3]
        if (str == "XMAS")
            res += 1
    }

    if (i + 3 < input.size && j + 3 < input[i].length) {
        val str = "" + input[i][j] + input[i+1][j+1] + input[i+2][j+2] + input[i+3][j+3]
        if (str == "XMAS")
            res += 1
    }


    if (i - 3 >= 0 && j + 3 < input[i].length) {
        val str = "" + input[i][j] + input[i-1][j+1] + input[i-2][j+2] + input[i-3][j+3]
        if (str == "XMAS")
            res += 1
    }

    if (i + 3 < input.size && j - 3 >= 0) {
        val str = "" + input[i][j] + input[i+1][j-1] + input[i+2][j-2] + input[i+3][j-3]
        if (str == "XMAS")
            res += 1
    }

    return res
}


fun getXMASCount(input: List<String>, i: Int, j: Int): Int {
    return getVertical(input, i, j) + getHorizontal(input, i, j) + getDiagonal(input, i, j)
}

fun isX_Mas(input: List<String>, i: Int, j: Int): Boolean {
    var x1 = ""
    var x2 = ""
    var y1 = ""
    var y2 = ""
    if (i + 1 < input.size && j + 1 < input[i].length && i - 1 >= 0 && j - 1 >= 0) {
         x1 = "" + input[i-1][j-1] + input[i][j] + input[i+1][j+1]
         x2 = "" + input[i+1][j+1] + input[i][j] + input[i-1][j-1]
         y1 = "" + input[i-1][j+1] + input[i][j] + input[i+1][j-1]
         y2 = "" + input[i+1][j-1] + input[i][j] + input[i-1][j+1]
    }

    return (x1 == "MAS" || x2 == "MAS") && (y1 == "MAS" || y2 == "MAS")
}

fun getX_MAXCount(input: List<String>, i: Int, j: Int): Int {
    return if (isX_Mas(input, i, j)) 1 else 0
}

fun main() {
    val input = File("src/day4/Task4_input.txt").readLines()

    var res1 = 0
    var res2 = 0

    for (i in 0..input.size - 1) {
        for (j in 0..input[i].length - 1) {
            res1 += getXMASCount(input, i, j)
            res2 += getX_MAXCount(input, i, j)
        }
    }
    println(res1)
    println(res2)
}