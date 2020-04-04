package Programmers.L4

private fun solution(distance: Int, rocks: IntArray, n: Int): Int {
    var answer = 0
    val newRocks = (rocks.sorted() + distance).toIntArray()
    var left = 0
    var right = distance
    while (left <= right) {
        val mid = (left + right) / 2
        when(removeRock(mid, newRocks, n)) {
            -1 -> right = mid - 1
            1 -> left = mid + 1
            0 -> {
                left = mid + 1
                answer = mid
            }
        }
    }
    return answer
}

fun removeRock(dis: Int, rocks: IntArray, n: Int): Int {
    var count = n
    var prev = 0
    var flag = 1
    for (r in rocks) {
        when {
            r - prev < dis -> if (count-- == 0) return -1
            else -> {
                if (r - prev == dis) flag = 0
                prev = r
            }
        }
    }
    return flag
}

fun main() {
    println(solution(25, intArrayOf(2, 14, 11, 21, 17), 2))
}