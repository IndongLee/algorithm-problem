package Programmers.Test

import java.util.*

val DY = intArrayOf(-1, 0, 1, 0)
val DX = intArrayOf(0, 1, 0, -1)

private fun solution(macaron: Array<IntArray>): Array<String> {
    val board = Array(6) { IntArray(6) }
    val visit = Array(6) { BooleanArray(6) }
    macaron.forEach {
        setMacaron(board, it[1], it[0] - 1)
        var isCrashed: Boolean
        do {
            isCrashed = false
            for (y in 0..5) {
                for (x in 0..5) {
                    if (board[y][x] != 0) {
                        val check = crashMacaron(board, visit, board[y][x], y, x)
                        isCrashed = if (!isCrashed && check) check else isCrashed
                    }
                }
            }
            if (isCrashed) fallMacaron(board)
            for (i in visit.indices) {
                visit[i].fill(false)
            }
        } while (isCrashed)
    }
    return board.map { it.joinToString("") }.toTypedArray()
}

fun setMacaron(board: Array<IntArray>, color: Int, line: Int) {
    for (i in 1..5) {
        if (board[i][line] != 0) {
            board[i-1][line] = color
            return
        }
    }
    board[5][line] = color
}

fun crashMacaron(board: Array<IntArray>, visit: Array<BooleanArray>, color: Int, y: Int, x : Int): Boolean {
    var isCrashed = false
    val cand = LinkedList<IntArray>()
    var count = 1
    val queue: Queue<IntArray> = LinkedList()
    queue.add(intArrayOf(y, x))
    cand.add(intArrayOf(y, x))
    visit[y][x] = true
    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        for (i in DY.indices) {
            val yi = cur[0] + DY[i]
            val xi = cur[1] + DX[i]
            if (yi in 0..5 && xi in 0..5 && board[yi][xi] == color && !visit[yi][xi]) {
                visit[yi][xi] = true
                val index = intArrayOf(yi, xi)
                cand.add(index)
                queue.add(index)
                count++
            }
        }
    }

    if (count >= 3) {
        isCrashed = true
        cand.forEach {
            board[it[0]][it[1]] = 0
        }
    }
    return isCrashed
}

fun fallMacaron(board: Array<IntArray>) {
    for (x in 0..5) {
        val queue: Queue<Int> = LinkedList()
        for (y in 5 downTo 0) {
            if (board[y][x] == 0) queue.add(y)
            else if (queue.isNotEmpty()) {
                val prev = queue.poll()
                board[prev][x] = board[y][x]
                board[y][x] = 0
                queue.add(y)
            }
        }
    }
}

fun main() {
    solution(
        arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(1, 2),
            intArrayOf(3, 3),
            intArrayOf(6, 4),
            intArrayOf(3, 1),
            intArrayOf(3, 3),
            intArrayOf(3, 3),
            intArrayOf(3, 4),
            intArrayOf(2, 1)
        )
    )
}