package Programmers.L3

import kotlin.math.abs

val dy = arrayOf(-1, 0, 1, 0)
val dx = arrayOf(0, 1, 0, -1)

private fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
    return build_frame.fold(HashSet<IntArray>()) { acc, ints ->
        val x = ints[0]
        val y = ints[1]
        val type = ints[2]
        val command = ints[3]
        when (command) {
            0 -> {
                if (acc.containsArray(intArrayOf(x, y, type))) {
                    acc.removeArray(intArrayOf(x, y, type))
                    if (!check(acc)) acc.add(intArrayOf(x, y, type))
                }
            }
            1 -> {
                acc.add(intArrayOf(x, y, type))
                if (!check(acc)) acc.removeArray(intArrayOf(x, y, type))
            }
        }
        acc
    }.sortedWith(compareBy({ it[0] }, { it[1] }, { it[2] })).toTypedArray()
}

fun check(jordySet: HashSet<IntArray>): Boolean {
    jordySet.forEach {
        val x = it[0]
        val y = it[1]
        val type = it[2]
        when (type) {
            0 -> {
                if (!(y == 0 || jordySet.containsArray(intArrayOf(x - 1, y, 1)) ||
                            jordySet.containsArray(intArrayOf(x, y, 1)) ||
                            jordySet.containsArray(intArrayOf(x, y - 1, 0)))
                ) {
                    return false
                }
            }
            1 -> {
                if (!(jordySet.containsArray(intArrayOf(x, y - 1, 0)) ||
                            jordySet.containsArray(intArrayOf(x + 1, y - 1, 0)) ||
                            (jordySet.containsArray(intArrayOf(x - 1, y, 1)) && jordySet.containsArray(intArrayOf(x + 1, y, 1))))
                ) {
                    return false
                }
            }
        }
    }
    return true
}

fun HashSet<IntArray>.containsArray(comp: IntArray): Boolean {
    this.forEach {
        if (it.contentEquals(comp)) return true
    }
    return false
}

fun HashSet<IntArray>.removeArray(comp: IntArray) {
    this.forEach {
        if (it.contentEquals(comp)) {
            this.remove(it)
            return
        }
    }
}


fun main() {
    solution(5, arrayOf(intArrayOf()))
}