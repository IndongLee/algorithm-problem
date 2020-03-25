package Programmers

import kotlin.math.max
import kotlin.math.pow

fun checkNumber(number: Int, targetArray: IntArray): Boolean {
    var n = number
    while (n != 0) {
        targetArray[n%10]--
        if (targetArray[n%10] < 0) return false
        n /= 10
    }
    return true
}

private fun solution(numbers: String): Int {
    val maxNum = numbers.toCharArray().sortedDescending().fold("") {acc, c -> acc + c.toString() }.toInt()
    var answer = 0
    val numbersArray = IntArray(10) { 0 }
    numbers.forEach { numbersArray[it.toString().toInt()]++ }
    val prime = Array(maxNum + 1) { true }
    for (i in 2..maxNum) {
        if (!prime[i]) continue
        if (checkNumber(i, numbersArray.copyOf())) answer++
        for (j in i*2..maxNum step i) prime[j] = false
    }
    return answer
}


fun main() {
    println(solution("011"))
    println("1".substring(1..0) == "")
}