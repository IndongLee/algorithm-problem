package Programmers.L2

private fun solution(baseball: Array<IntArray>): Int {
    var cand = Array(1000 - 123) { (it + 123).toString() }.filter { !it.contains('0') && it[0] != it[1] && it[1] != it[2] && it[0] != it[2] }
    println(cand)
    for (game in baseball) cand = cand.filter { baseballGame(it, game[0].toString()).contentEquals(game.sliceArray(1..2)) }
    return cand.size
}

fun baseballGame(target: String, ball: String): IntArray {
    val judgment = intArrayOf(0, 0)
    for (i in 0..2) {
        when (target[i]) {
            ball[i] -> judgment[0]++
            in ball -> judgment[1]++
        }
    }
    return judgment
}

fun main() {
    solution(
        arrayOf(
            intArrayOf(123, 1, 1),
            intArrayOf(356, 1, 0),
            intArrayOf(327, 2, 0),
            intArrayOf(489, 0, 1)
        )
    )
}