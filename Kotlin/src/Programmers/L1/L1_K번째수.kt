package Programmers.L1

import java.util.*

private fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
    return commands.map { it -> array.sliceArray(it[0]-1..it[1]-1).sorted()[it[2]-1] }.toIntArray()
}

fun main() {
    println(Arrays.toString(
        solution(
            intArrayOf(1, 5, 2, 6, 3, 7, 4),
            arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
        )
    ))
}