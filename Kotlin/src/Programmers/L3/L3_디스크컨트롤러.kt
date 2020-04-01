package Programmers.L3

import java.util.*

private fun solution(jobs: Array<IntArray>): Int {
    jobs.sortWith(
        kotlin.Comparator { o1, o2 ->
            when {
                o1[0] > o2[0] -> 1
                o1[0] < o2[0] -> -1
                o1[1] > o2[1] -> 1
                o1[1] < o2[1] -> -1
                else -> 0
            }
        }
    )
    jobs.reversed().forEach { it[0] -= jobs[0][0] }

    val length = jobs.size
    var answer = 0
    var end = 0
    var cur = 0
    val hqueue = PriorityQueue<Int>()
    while (cur < length || hqueue.isNotEmpty()) {
        for (i in cur until length) {
            if (jobs[i][0] > end) break
            hqueue.add(jobs[i][1])
            answer += (end - jobs[i][0])
            cur++
        }
        if (hqueue.isNotEmpty()) {
            answer += hqueue.size * hqueue.peek()
            end += hqueue.poll()
        } else end++
    }
    return answer / length
}

fun main() {
    println(solution(arrayOf(intArrayOf(1, 3), intArrayOf(2, 9), intArrayOf(3, 6))))
}