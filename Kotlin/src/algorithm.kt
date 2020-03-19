import java.util.*
import kotlin.collections.ArrayList

data class Edge(val weight: Int, val node: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge) = when {
        weight < other.weight -> -1
        weight > other.weight -> 1
        else -> 0
    }
}

fun main() {
    val INF = Int.MAX_VALUE
    val dis = Array( V + 1 ) { INF }
    dis[1] = 0

    for (i in 1..V) {
        // path = [[1, 2, 8], [1, 3, -2], ... , [4, 6, 5]]
        for (path in paths) {
            temp = dis[path[0]] + path[2]
            if (dis[path[1]] > temp) dis[path[1]] = temp
        }
    }

    for (path in paths) {
        if (dis[path[1]] <= dis[path[0]] + path[2]) return false
    }
    retrun true

}

tailrec fun <T: Comparable<T>> ArrayList<T>.heapify(index: Int = 0, heapSize: Int = size) {
    val leftIndex = index * 2 + 1
    val rightIndex = index * 2 + 2
    var largest = index
    if (rightIndex < heapSize && this[rightIndex] > this[largest]) largest = rightIndex
    if (leftIndex < heapSize && this[leftIndex] > this[largest]) largest = leftIndex
    if (largest != index) {
        Collections.swap(this, index, largest)
        heapify(largest)
    }
}

fun <T: Comparable<T>> ArrayList<T>.buildHeap() {
    for (i in (size) / 2 downTo 0) {
        this.heapify(i)
    }
}

fun <T: Comparable<T>> ArrayList<T>.heappush(item: T) {
    var idx = size
    add(item)
    while (idx != 0 && item > this[idx/2]) {
        Collections.swap(this, idx, idx/2)
        idx /= 2
    }
}

fun <T: Comparable<T>> ArrayList<T>.heappop() : T {
    Collections.swap(this, 0, size-1)
    val popValue = removeLast()
    heapify()
    return popValue
}