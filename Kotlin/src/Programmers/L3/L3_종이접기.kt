package Programmers.L3

import kotlin.collections.ArrayList

private fun solution(n: Int): IntArray {
    return paper(n)
}

tailrec fun paper(n: Int, count: Int = 1, paperArray: IntArray = intArrayOf(0)) : IntArray {
    return if (n == 1) paperArray else paper(n-1, count+1, paperArray + intArrayOf(0) + paperArray.reversed().map {
        if (it == 0) 1 else 0
    }.toIntArray())
}

fun main() {
    println(paper(5).contentToString())
}