package io.kshired.advent.of.code.day2

import java.io.File
import kotlin.streams.toList

private const val RED = 12
private const val GREEN = 13
private const val BLUE = 14

fun main() {
    val curDir = System.getProperty("user.dir")
    val file = File(curDir, "src/main/kotlin/io/kshired/advent/of/code/day2/day2.txt")
    val bufferedReader = file.bufferedReader()

    val result = bufferedReader.lines().toList().mapIndexed { index, game ->
        val sets = game.substring("Game ${index+1}: ".length).split(";")
        val isFullFilled = sets.all { set ->
            set.split(",").all { info ->
                val data = info.trim().split(" ")
                val count = data[0].toInt()
                val color = data[1]

                 when (color) {
                    "red" -> count <= RED
                    "green" -> count <= GREEN
                    "blue" -> count <= BLUE
                    else -> false
                }
            }
        }

        if (isFullFilled) index + 1 else 0
    }.sum()

    println(result)
}

private fun isNumber(char: Char) = char in '0'..'9'
