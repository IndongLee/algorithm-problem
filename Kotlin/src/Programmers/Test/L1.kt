package Programmers.Test

import java.util.*

private fun solution(inputString: String): Int {
    val open = setOf('(', '{', '[', '<')
    val close = setOf(')', '}', ']', '>')
    val stack = Stack<Char>()
    var answer = 0
    for (s in inputString) {
        when (s) {
            in open -> stack.add(s)
            in close -> {
                if (stack.isEmpty() || stack.peek() in close) return -1
                else {
                    stack.pop()
                    answer++
                }
            }
        }
    }
    return if (stack.isEmpty()) answer else -1
}

fun main() {

}