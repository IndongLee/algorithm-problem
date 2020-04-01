package Programmers.L2

private fun solution(citations: IntArray): Int {
    var answer = 0
    citations.sortedDescending().forEachIndexed { index, i ->
        if (i <= index) return@forEachIndexed
        answer++
    }
    return answer
}

fun main() {
    println(solution(intArrayOf(7)))

}