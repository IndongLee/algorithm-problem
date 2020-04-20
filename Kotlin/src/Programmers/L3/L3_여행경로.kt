package Programmers.L3

import kotlin.collections.ArrayList

private fun solution(tickets: Array<Array<String>>): Array<String> {
    val start = hashMapOf<String, ArrayList<Int>>()
    tickets.forEachIndexed { index, ticket ->
        if (!start.containsKey(ticket[0])) {
            start[ticket[0]] = arrayListOf()
        }
        start[ticket[0]]!!.add(index)
    }

    val adj = hashMapOf<Int, ArrayList<Int>>()
    tickets.forEach {  }
    println(start)


    return arrayOf()
}



fun main() {
    println(
        solution(
            arrayOf(
                arrayOf("ICN", "JFK"),
                arrayOf("HND", "IAD"),
                arrayOf("JFK", "HND")
            )
        )
    )
}
