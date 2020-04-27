package Programmers.L3

private fun solution(arr: IntArray): Int = arr.fold(1) { acc, num ->
    lcm(acc, num)
}

fun gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)

fun lcm(x: Int, y: Int): Int = x * y / gcd(x, y)

fun main() {
    println(gcd(78696, 19332))
}