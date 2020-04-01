package Programmers.L2

private fun solution(numbers: IntArray): String {
    var answer = ""
    Array(numbers.size) { numbers[it].toString() }.sortedWith(
        kotlin.Comparator { n1, n2 ->
            when {
                n1 + n2 > n2 + n1 -> -1
                n1 + n2 < n2 + n1 -> 1
                else -> 0
            }
        }
    ).forEach { if (answer != "0") answer += it }

    return answer
}

fun main() {
    println(solution(intArrayOf(0, 0, 0, 0)))
}
