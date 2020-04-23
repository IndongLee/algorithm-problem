package Programmers.L2

private fun solution(s: String): String =
    s.split(" ").fold(Pair(Int.MAX_VALUE, Int.MIN_VALUE)) { acc, num ->
        val cur = num.toInt()
        Pair(if (acc.first > cur) cur else acc.first, if (acc.second < cur) cur else acc.second)
    }.run { "$first $second" }

fun main() {
    println(solution("1 2 3 4"))
}