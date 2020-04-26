package Programmers.L2

private fun solution(n: Int): Int = fibonacci(n, 0, 1)

tailrec fun fibonacci(n: Int, prev: Int, next: Int): Int = if (n == 0) prev else fibonacci(n-1, next, (prev+next) % 1234567)

fun main() {
    println(solution(100_000))
}