package Programmers.L3

private fun solution(n: Int): Long {
    return jump(n, 1, 2)
}

tailrec fun jump(n: Int, a: Long, b: Long): Long {
    if (n == 1) return a
    return jump(n - 1, b % 1234567L, (a + b) % 1234567L)
}

fun main() {
    println(solution(2000))
}