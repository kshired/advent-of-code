package io.kshired.advent.of.code.day1

import java.io.File
import kotlin.streams.toList

fun main() {
    val curDir = System.getProperty("user.dir")
    val file = File(curDir, "src/main/kotlin/io/kshired/advent/of/code/day1/day1.txt")
    val bufferedReader = file.bufferedReader()

    val result = bufferedReader.lines().map {
        val candidates = it.mapNotNull { c ->
            when {
                isNumber(c) -> c.toString().toInt()
                else -> null
            }
        }

        if (candidates.size == 1) candidates[0] * 11 else candidates[0] * 10 + candidates.last()
    }.toList().sum()

    println(result)
}

private fun isNumber(char: Char) = char in '0'..'9'
