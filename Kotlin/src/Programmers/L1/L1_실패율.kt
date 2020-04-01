package Programmers.L1

import java.util.*

private fun solution(N: Int, stages: IntArray): IntArray {
    var u = stages.size.toDouble()
    var failedUsers = Array(N+2) { 0 }
    stages.forEach { ++failedUsers[it] }

    var failedPer = mutableListOf<Pair<Int, Double>>()
    for (i in 1..N) {
        val cur = failedUsers[i].toDouble()
        failedPer.add(Pair(i, cur / u))
        u -= cur
    }

    return failedPer.sortedWith(
        kotlin.Comparator { p1, p2 ->
            when {
                p1.second > p2.second -> -1
                p1.second < p2.second -> 1
                p1.first < p2.first -> -1
                p1.first > p2.first -> 1
                else -> 0
            }
        }
    ).map { it.first }.toIntArray()
}

fun main() {
    println(Arrays.toString(solution(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3))))
}