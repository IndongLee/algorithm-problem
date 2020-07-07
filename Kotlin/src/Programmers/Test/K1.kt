package Programmers.Test

import java.util.*

private fun getMin(s: String): Int {
    val stack = Stack<Char>()
    s.forEach {
        when (it) {
            '(' -> stack.add(it)
            else -> {
                if (stack.isEmpty() || stack.peek() == ')') stack.add(it)
                else stack.pop()
            }
        }
    }
    return stack.size
}

fun main() {
    println(getMin("(()))"))
}