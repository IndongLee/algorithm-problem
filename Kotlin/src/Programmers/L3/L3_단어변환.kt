package Programmers.L3

import java.util.*

fun checkEdge(node1: String, node2: String): Boolean {
    var count = 0
    for (i in node1.indices) {
        if (node1[i] != node2[i] && ++count > 1) return false
    }
    return true
}

private fun solution(begin: String, target: String, words: Array<String>): Int {
    val adj = Array(words.size) { arrayListOf<Int>() }
    for (i in words.indices) {
        for (j in i+1 until words.size) {
            if (checkEdge(words[i], words[j])) {
                adj[i].add(j)
                adj[j].add(i)
            }
        }
    }

    val queue: Queue<Int> = LinkedList()
    val vis = Array(words.size) { false }
    for (i in words.indices) {
        if (checkEdge(begin, words[i])) {
            queue.add(i)
            vis[i] = true
        }
    }
    var answer = 0
    while (queue.isNotEmpty()) {
        answer++
        for (i in 1..queue.size) {
            val cur = queue.poll()
            if (words[cur] == target) return answer
            for (next in adj[cur]) {
                if (!vis[next]) {
                    queue.add(next)
                    vis[next] = true
                }
            }
        }
    }

    return 0
}

fun main() {
    println(solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log")))
}