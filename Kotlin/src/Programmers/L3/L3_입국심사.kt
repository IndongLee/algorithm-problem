package Programmers.L3

private fun solution(n: Int, times: IntArray): Long {
    var min = 1L
    var max = times.max()!!.toLong() * n
    var answer = max
    while (min <= max) {
        val mid = (min + max) / 2
        val count = times.fold(0L) { total, next -> total + mid / next }
        if (n <= count) {
            answer = answer.coerceAtMost(mid)
            max = mid - 1
        } else {
            min = mid + 1
        }
    }
    return answer
}

fun main() {
    println(solution(6, intArrayOf(7, 10)))
}