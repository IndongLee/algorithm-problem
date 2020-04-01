package Programmers.L1

import java.util.*

val p1 = arrayOf(1, 2, 3, 4, 5)
val p2 = arrayOf(2, 1, 2, 3, 2, 4, 2, 5)
val p3 = arrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

private fun solution(answers: IntArray): IntArray {
    var scores = IntArray(3) { 0 }
    for (i in answers.indices) {
        if (answers[i] == p1[i%5]) scores[0]++
        if (answers[i] == p2[i%8]) scores[1]++
        if (answers[i] == p3[i%10]) scores[2]++
    }
    var answer = scores.mapIndexed { index, i -> index + 1 }.filter { scores[it-1] == scores.max() }.toIntArray()
    return answer
}


fun main() {
    solution(intArrayOf(1, 3, 2, 4, 2))
    println(Arrays.toString(solution(intArrayOf(1, 3, 2, 4, 2))))
}