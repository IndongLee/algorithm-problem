package Programmers

import java.util.*

private fun solution(board: Array<IntArray>, moves: IntArray): Int {
    fun useCrane(line: Int): Int {
        var result = 0
        for (i in board.indices) {
            if (board[i][line] != 0) {
                result = board[i][line]
                board[i][line] = 0
                break
            }
        }
        return result
    }

    val stack: Stack<Int> = Stack()
    return moves.fold(0) { acc, i ->
        val doll = useCrane(i-1)
        println(doll)
        when {
            doll == 0 -> acc
            stack.isEmpty() || stack.peek() != doll -> {
                stack.add(doll)
                acc
            }
            else -> {
                stack.pop()
                acc + 2
            }
        }
    }
}

fun main() {

}