package Programmers.L2

import kotlin.math.ceil
import kotlin.math.pow

private fun solution(n: Int, a: Int, b: Int): Int {
    var answer = 0
    for (i in 1..20) {
        if (ceil(a / 2.0.pow(i)) == ceil(b / 2.0.pow(i))) {
            answer = i
            break
        }
    }
    return answer
}

fun main() {

}