package Programmers.Test

import java.util.*
import kotlin.math.abs

private fun solution(board: Array<IntArray>): Int {
    val dxy = arrayOf(intArrayOf(-1, 0), intArrayOf(0, -1))
    val checkBoard = Array(15) { Array(15) { intArrayOf(1, 1) } }
    val visitBoard = Array(15) { BooleanArray(15) { false } }

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(14, 14))
    visitBoard[14][14] = true

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        val y = cur.first
        val x = cur.second

        if (board[y][x] != 0) {
            if (y in 0..13 && board[y][x] != 0 && board[y][x] == board[y+1][x]) {
                checkBoard[y][x][0] = checkBoard[y+1][x][0] + 1
            }
            if (x in 0..13 && board[y][x] != 0 && board[y][x] == board[y][x+1]) {
                checkBoard[y][x][1] = checkBoard[y][x+1][1] + 1
            }
        }

        dxy.forEach { dArray ->
            val yi = y + dArray[0]
            val xi = x + dArray[1]

            if (yi in 0..14 && xi in 0..14 && !visitBoard[yi][xi]) {
                visitBoard[yi][xi] = true
                queue.add(Pair(yi, xi))
            }
        }
    }

    for (y in 0..14) {
        for (x in 0..14) {
            if (checkBoard[y][x][0] == 5) {
                if (y == 0 || board[y-1][x] != board[y][x]) {
                    return board[y][x]
                }
            }
            if (checkBoard[y][x][1] == 5) {
                if (x == 0 || board[y][x-1] != board[y][x]) {
                    return board[y][x]
                }
            }
        }
    }
    return 0
}

fun main() {

}