import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val heap = arrayListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(heap)
    heap.buildHeap()
    println(heap)
    for (i in 1..9) {
        heap.heappop()
        println(heap)
    }

}


tailrec fun <T: Comparable<T>> ArrayList<T>.heapify(index: Int = 1, heapSize: Int = size) {
    val leftIndex = index * 2
    val rightIndex = index * 2 + 1
    var largest = index
    if (rightIndex < heapSize && this[rightIndex] > this[largest]) largest = rightIndex
    if (leftIndex < heapSize && this[leftIndex] > this[largest]) largest = leftIndex
    if (largest != index) {
        Collections.swap(this, index, largest)
        heapify(largest)
    }
}

fun <T: Comparable<T>> ArrayList<T>.buildHeap() {
    for (i in (size) / 2 downTo 1) {
        this.heapify(i)
    }
}

fun <T: Comparable<T>> ArrayList<T>.heappush(item: T) {
    var idx = size
    if (idx == 0) add(item)
    add(item)
    while (idx != 1 && item > this[idx/2]) {
        Collections.swap(this, idx, idx/2)
        idx /= 2
    }
}

fun <T: Comparable<T>> ArrayList<T>.heappop() {
    Collections.swap(this, 1, size-1)
    val popValue = removeLast()
    heapify()
}