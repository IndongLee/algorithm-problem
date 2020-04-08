package Programmers.L3

import java.util.*

private fun solution(n: Int, edge: Array<IntArray>): Int {
    val vis = BooleanArray(n + 1)
    val adj = Array(n + 1) { LinkedList<Int>() }
    edge.forEach {
        adj[it[0]].add(it[1])
        adj[it[1]].add(it[0])
    }

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val levelMap = hashMapOf<Int, Int>()
    queue.add(Pair(1, 0))
    vis[1] = true
    levelMap[0] = 1

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        adj[cur.first].forEach {
            if (!vis[it]) {
                vis[it] = true
                val nextLevel = cur.second + 1
                levelMap[nextLevel] = if (!levelMap.containsKey(nextLevel)) 1 else levelMap[nextLevel]!! + 1
                queue.add(Pair(it, nextLevel))
            }
        }
    }
    return levelMap[levelMap.maxBy { it.key }!!.value]!!
}

fun main() {

}