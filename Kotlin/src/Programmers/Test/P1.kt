package Programmers.Test

private fun solution(moves: Array<String>): Int {
    val board = HashMap<Pair<Int, Int>, IntArray>()
    val dirMap = mapOf(
        "U" to intArrayOf(0, -1),
        "D" to intArrayOf(0, 1),
        "L" to intArrayOf(-1, 0),
        "R" to intArrayOf(1, 0)
    )
    var current = Pair(0, 0)

    moves.forEach { dir ->
        val next = getNextIndex(dirMap, current, dir)
        move(board, current, next, dir)
        current = next
    }

    return board.keys.fold(0) { acc, index ->
        acc + checkSquare(board, dirMap, index)
    }
}

fun getNextIndex(
    dirMap: Map<String, IntArray>,
    current: Pair<Int, Int>,
    dir: String
): Pair<Int, Int> {
    return Pair(current.first + dirMap.getValue(dir)[0], current.second + dirMap.getValue(dir)[1])
}

fun move(
    board: HashMap<Pair<Int, Int>, IntArray>,
    current: Pair<Int, Int>,
    next: Pair<Int, Int>,
    dir: String
) {
    makeIndex(board, current)
    makeIndex(board, next)

    when (dir) {
        "U" -> board[next]!![0] = 1
        "D" -> board[current]!![0] = 1
        "L" -> board[next]!![1] = 1
        "R" -> board[current]!![1] = 1
    }
}

fun makeIndex(
    board: HashMap<Pair<Int, Int>, IntArray>,
    index: Pair<Int, Int>
) {
    if (!board.containsKey(index)) {
        board[index] = intArrayOf(0, 0)
    }
}

fun checkSquare(
    board: HashMap<Pair<Int, Int>, IntArray>,
    dirMap: Map<String, IntArray>,
    current: Pair<Int, Int>
): Int {
    val down = board[getNextIndex(dirMap, current, "D")]
    val right = board[getNextIndex(dirMap, current, "R")]

    return when {
        down == null || right == null -> 0
        down[1] == 1 && right[0] == 1 && board[current]!!.contentEquals(intArrayOf(1, 1)) -> 1
        else -> 0
    }
}

fun main() {
    print(solution(
        arrayOf(
            "U", "L", "D", "R", "R", "D", "D", "L", "U", "U"
        )
    ))
}