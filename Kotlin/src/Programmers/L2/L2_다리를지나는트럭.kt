package Programmers.L2

import java.util.*

class Truck(val weight: Int, var time: Int)

private fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    var now = weight
    val N = truck_weights.size
    var answer = 1
    val queue: Queue<Truck> = LinkedList()
    queue.add(Truck(truck_weights[0], answer))
    now -= truck_weights[0]
    var idx = 1
    while (queue.isNotEmpty()) {
        queue.let {
            if (it.element().time + bridge_length == ++answer) now += it.poll().weight
            if (idx < N && now >= truck_weights[idx]) {
                now -= truck_weights[idx]
                queue.add(Truck(truck_weights[idx++], answer))
            }
        }
        println(answer)
        println(queue)
    }
    return answer
}

fun main() {
    println(solution(100, 100, intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10)))
}