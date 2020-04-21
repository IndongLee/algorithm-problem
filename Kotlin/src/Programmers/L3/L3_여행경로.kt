package Programmers.L3

import java.util.*

private fun solution(tickets: Array<Array<String>>): Array<String> {
    val adj = hashMapOf<String, LinkedList<String>>()
    tickets.forEach {
        if (!adj.containsKey(it[0])) adj[it[0]] = LinkedList()
        adj[it[0]]!!.add(it[1])
    }
    adj.map { it.value.sort() }

    val stack = Stack<String>()
    stack.add("ICN")
    val path = arrayListOf<String>()

    while (stack.isNotEmpty()) {
        val cur = stack.peek()
        if (!adj.containsKey(cur) || adj[cur]!!.isEmpty()) {
            path.add(stack.pop())
        } else {
            stack.add(adj[cur]!!.pop())
        }
    }

    return path.reversed().toTypedArray()
}

fun main() {
    println(
        solution(
            arrayOf(
                arrayOf("ICN", "SFO"),
                arrayOf("ICN", "ATL"),
                arrayOf("SFO", "ATL"),
                arrayOf("ATL", "ICN"),
                arrayOf("ATL", "SFO")
            )
        ).contentToString()
    )
}
