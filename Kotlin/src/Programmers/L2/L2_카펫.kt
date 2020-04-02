package Programmers.L2

private fun solution(brown: Int, red: Int): IntArray {
    for (i in 1 until red/2) {
        if (red % i == 0) {
            val j = red / i
            if (brown == 2 * (i + j) + 4) return intArrayOf(j, i)
        }
    }
    return intArrayOf(3, 3)
}

fun main() {

}