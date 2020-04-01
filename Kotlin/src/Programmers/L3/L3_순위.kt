package Programmers.L3

private fun solution(n: Int, results: Array<IntArray>): Int {
    var answer = 0
    val adj = Array(n + 1) { Array(n + 1) { false } }
    for (game in results) adj[game[0]][game[1]] = true
    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (adj[i][k] && adj[k][j]) adj[i][j] = true
            }
        }
    }
    println(adj.contentDeepToString())
    for (i in 1..n) {
        var count = 0
        for (j in 1..n) {
            if (adj[i][j] || adj[j][i]) count++
        }
        if (count == n - 1) answer++
    }
    return answer
}

fun main() {
    println(solution(1, arrayOf(intArrayOf(1, 1))))
}