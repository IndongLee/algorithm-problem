package Programmers.L3

import java.util.*
import kotlin.collections.ArrayList

private tailrec fun <T: Comparable<T>> ArrayList<T>.maxHeapify(index: Int = 0, heapSize: Int = size) {
    val leftIndex = index * 2 + 1
    val rightIndex = index * 2 + 2
    var largest = index
    if (rightIndex < heapSize && this[rightIndex] > this[largest]) largest = rightIndex
    if (leftIndex < heapSize && this[leftIndex] > this[largest]) largest = leftIndex
    if (largest != index) {
        Collections.swap(this, index, largest)
        maxHeapify(largest)
    }
}

private tailrec fun <T: Comparable<T>> ArrayList<T>.minHeapify(index: Int = 0, heapSize: Int = size) {
    val leftIndex = index * 2 + 1
    val rightIndex = index * 2 + 2
    var smallest = index
    if (rightIndex < heapSize && this[rightIndex] < this[smallest]) smallest = rightIndex
    if (leftIndex < heapSize && this[leftIndex] < this[smallest]) smallest = leftIndex
    if (smallest != index) {
        Collections.swap(this, index, smallest)
        minHeapify(smallest)
    }
}

fun <T: Comparable<T>> ArrayList<T>.heappop(max: Boolean): T {
    Collections.swap(this, 0, size-1)
    val popValue = removeLast()
    if (max) maxHeapify() else minHeapify()
    return popValue
}

fun <T: Comparable<T>> ArrayList<T>.buildHeap(max: Boolean) {
    for (i in (size) / 2 downTo 0) {
        if (max) maxHeapify(i) else minHeapify(i)
    }
}

private fun solution(operations: Array<String>): IntArray {
    val heap = arrayListOf<Int>()
    operations.forEach {
        when {
            it[0] == 'I' -> heap.add(it.drop(2).toInt())
            heap.isEmpty() -> {}
            it == "D 1" -> {
                heap.buildHeap(true)
                heap.heappop(true)
            }
            else -> {
                heap.buildHeap(false)
                heap.heappop(false)
            }
        }
    }
    var answer = if (heap.isNotEmpty()) intArrayOf(heap.max()!!, heap.min()!!) else intArrayOf(0, 0)
    return answer
}

fun main() {

}