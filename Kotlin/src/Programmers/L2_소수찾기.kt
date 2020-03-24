package Programmers

import kotlin.math.pow

fun String.powerset(): Set<String> = powerset(this, setOf(""))

private tailrec fun powerset(left: String, acc: Set<String>): Set<String> = when {
    left == "" -> acc
    else -> powerset(left.substring(1 until left.length), acc + acc.map { it + left[0] })
}

private fun solution(numbers: String): Int {
    val prime = Array(10.0.pow(numbers.length.toDouble()).toInt() + 1) { true }
    prime[0] = false
    prime[1] = false
    for (i in 2 until prime.size) {
        if (!prime[i]) continue
        for (j in i*2 until prime.size step i) prime[j] = false
    }
    var answer = 0
    numbers.powerset().drop(1).forEach {
        println(it)
        if (prime[it.toInt()]) {
            prime[it.toInt()] = false
            answer++
        }
    }
    return answer
}



fun main() {
    println(solution("011"))
    println("1".substring(1..0) == "")
}