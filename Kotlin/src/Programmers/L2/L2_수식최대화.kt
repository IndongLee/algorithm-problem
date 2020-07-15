package Programmers.L2

import java.util.*
import kotlin.math.abs
import kotlin.math.max


class Solution {
    private val operator: CharArray = charArrayOf('+', '-', '*')

    fun solution(expression: String): Long {
        val expressionList: List<String> = separateStringExpression(expression)

        return makeMaxResultNumber(expressionList, booleanArrayOf(false, false, false), 0)
    }

    private fun separateStringExpression(expression: String): List<String> {
        val number = StringBuilder()
        val lastIndex = expression.length - 1

        return expression.foldIndexed(mutableListOf()) { index, list, char ->
            when (char) {
                in operator -> {
                    list.add(number.toString())
                    number.clear()
                    list.add(char.toString())
                }
                else -> {
                    number.append(char)
                    if (index == lastIndex) {
                        list.add(number.toString())
                    }
                }
            }
            list
        }
    }

    private fun combineNumberInListBy(operator: String, expressionList: List<String>): List<String> {
        val stack: Stack<String> = Stack()

        expressionList.forEach { expression ->
            if (stack.isNotEmpty() && stack.peek() == operator) {
                stack.add(calculateNumbers(stack.pop(), stack.pop().toLong(), expression.toLong()))
            } else {
                stack.add(expression)
            }
        }

        return stack.toList()
    }

    private fun makeMaxResultNumber(resultNumberList: List<String>, visited: BooleanArray, count: Int = 0): Long {
        if (count == 3) {
            return abs(resultNumberList[0].toLong())
        }

        var maxResult: Long = 0
        for (i in 0..2) {
            if (!visited[i]) {
                visited[i] = true
                maxResult = max(maxResult, makeMaxResultNumber(
                    combineNumberInListBy(operator[i].toString(), resultNumberList),
                    visited,
                    count + 1
                ))
                visited[i] = false
            }
        }
        return maxResult
    }

    private fun calculateNumbers(operator: String, first: Long, second: Long): String {
        return when (operator) {
            "+" -> first + second
            "-" -> first - second
            "*" -> first * second
            else -> first / second
        }.toString()
    }
}

fun main() {
    println("123+456*789".split(*charArrayOf('+', '-', '*')))
    Solution().solution("123-456+789")
}