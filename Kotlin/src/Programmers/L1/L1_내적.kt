package Programmers.L1

private fun solution(a: IntArray, b: IntArray): Int {
    return a.zip(b, Int::times).sum()
}

fun main() {

}