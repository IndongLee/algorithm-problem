package Programmers.L1

private fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
    var answer = 0
    var clothes = Array<Int>(n) { 1 }
    for (l in lost) --clothes[l-1]
    for (r in reserve) ++clothes[r-1]
    for (i in 0 until n) {
        if (clothes[i] >= 1) {
            ++answer
            continue
        }
        when {
            i - 1 >= 0 && clothes[i-1] == 2 -> {
                --clothes[i-1]
                ++clothes[i]
                ++answer
            }
            i + 1 < n && clothes[i+1] == 2 -> {
                --clothes[i+1]
                ++clothes[i]
                ++answer
            }
        }
    }
    return answer
}

fun main() {
    println(solution(7, intArrayOf(2, 4, 6), intArrayOf(3, 6)))
}