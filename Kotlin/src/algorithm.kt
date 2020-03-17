import java.lang.Exception
import java.util.*

class Node<T>(var value: T, var prev: Node<T>? = null, var next: Node<T>? = null)

class Queue<T>(var head: Node<T>? = null ) {
    var size = 0
    var tail: Node<T>? = null

    fun isEmpty() = size == 0

    fun isNotEmpty() = size != 0

    fun enqueue(value: T) {
        if (isEmpty()) {
            tail = Node(value)
            head = tail
        } else {
            tail!!.next = Node(value, tail)
        }
        size++
    }

    fun dequeue(): T {
        val result = head!!.value
        when (size) {
            0 -> throw Exception("Stack Underflow")
            1 -> {
                head = null
                tail = null
            }
            else -> {
                head!!.next!!.prev = null
                head = head!!.next
            }
        }
        size--
        return result
    }

    fun peek(): T {
        if (isEmpty()) throw Exception("Stack Underflow")
        return head!!.value
    }
}

fun main() {

}