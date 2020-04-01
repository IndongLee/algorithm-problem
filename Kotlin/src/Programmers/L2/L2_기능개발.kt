package Programmers.L2

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.ceil

private fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    val list = LinkedList<Int>()
    val answer = ArrayList<Int>()
    progresses.forEachIndexed { index, i ->
        val day = ceil((100 - i).toDouble() / speeds[index].toDouble()).toInt()
        if (list.isEmpty() || list.last < day) {
            list.add(day)
            answer.add(1)
        } else {
            answer[answer.size-1]++
        }
        println(list)
    }
    println(answer)
    return answer.toIntArray()
}

fun main() {
    solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5))

}