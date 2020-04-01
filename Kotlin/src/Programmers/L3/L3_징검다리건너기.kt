package Programmers.L3

private fun solution(stones: IntArray, k: Int): Int {
    var answer = stones.max()!!
    val len = stones.size
    var now = -1
    outer@while (now < len) {
        var tempValue = 0
        var tempIndex = if (now + k < len) now + k else len - 1
        for (i in now+1..now+k) {
            if (i >= len) break@outer
            if (tempValue < stones[i]) {
                tempValue = stones[i]
                tempIndex = i
                if (answer <= stones[i]) break
            }
        }
        if (answer >= tempValue) answer = tempValue
        now = tempIndex
    }
    return answer
}

fun main() {
    println(solution(intArrayOf(1, 1, 1, 2, 2), 1))
}