package Programmers

import kotlin.math.ln1p

private fun solution(priorities: IntArray, location: Int): Int {
    return priorities.indices.asSequence().groupBy { priorities[it] }
        .toList()
        .sortedByDescending { it.first }
        .map { it.second }
        .reduce { acc, list ->
            val pivot = if (acc.isEmpty()) -1 else acc[acc.size-1]
            val temp = list.partition { it < pivot }
            acc + temp.second + temp.first
        }.indexOf(location) + 1
}

fun main() {
    println(solution(intArrayOf(1, 3, 2, 4, 1, 5, 9, 1, 2, 4, 5), 7))
}