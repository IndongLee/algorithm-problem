package Programmers.L2

private fun solution(s: String): IntArray {
    return s.substring(2 until s.length-2)
        .split("},{")
        .asSequence()
        .map { it.split(",").map { num -> num.toInt() } }
        .toList()
        .sortedBy { it.size }
        .fold(setOf<Int>()) { acc, list -> acc.union(list) }
        .toIntArray()
}

fun main() {

}