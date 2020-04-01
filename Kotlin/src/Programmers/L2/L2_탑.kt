package Programmers.L2

import java.util.*

private fun solution(heights: IntArray): IntArray {
    val N = heights.size
    var answer = IntArray(N) { 0 }
    var stack = Stack<Pair<Int, Int>>()
    for (i in N-1 downTo 0) {
        while (stack.isNotEmpty() && stack.peek().second < heights[i]) {
            answer[stack.pop().first] = i + 1
        }
        stack.push(Pair(i, heights[i]))
    }
    return answer
}

fun main() {
    println(Arrays.toString(solution(intArrayOf(1, 5, 3, 6, 7, 6, 5))))
}