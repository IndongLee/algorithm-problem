package Programmers.Test

import kotlin.math.max

private fun solution(road: String, n: Int): Int {
    var status = arrayListOf(1)
    var prev = road[0]
    var index = 0
    for (i in 1 until road.length) {
        when (road[i]) {
            prev -> status[index]++
            else -> {
                prev = road[i]
                status.add(1)
                index++
            }
        }
    }
    if (road[0] == '0') {
        status.add(0, 0)
        status.add(0)
    }

    var answer = 0
    var len = status[0]
    var count = n
    var right = 1
    for (left in 1..status.size-2 step 2) {
        if (left != 1) {
            println(left)
            val prev = left - 2
            len -= status[prev-1] + status[prev]
            count += status[prev]
        }
        while (right < status.size - 1 && count >= status[right]) {
            len += (status[right] + status[right+1])
            count -= status[right]
            right += 2
        }
        answer = max(answer, len)
    }

    return answer
}

fun main() {
    println(solution("111011110011111011111100011111", 3))
}