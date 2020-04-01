package Programmers.L3

private fun solution(N: Int, number: Int): Int {
    var answer = -1
    val dp = Array(8) { hashSetOf( Array(it + 1) { "1" }.fold("") { total, next -> total + next }.toInt() * N ) }

    first@for (i in 1..7) {
        for (j in 0 until i) {
            for (num1 in dp[j]) {
                 for (num2 in dp[i-j-1]) {
                     dp[i].add(num1 + num2)
                     dp[i].add(num1 - num2)
                     dp[i].add(num1 * num2)
                     if (num2 != 0) dp[i].add(num1 / num2)
                 }
            }
        }

        if (number in dp[i]) {
            answer = i + 1
            first@break
        }
    }
    return answer
}

fun main() {
    println(solution(2, 11))
}