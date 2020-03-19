import java.util.*
import kotlin.collections.ArrayList

data class Edge(val weight: Int, val node: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge) = when {
        weight < other.weight -> -1
        weight > other.weight -> 1
        else -> 0
    }
}

fun <T> Array<T>.swap(left: Int, right: Int) {
    val save = this[left]
    this[left] = this[right]
    this[right] = save
}

fun <T: Comparable<T>> bubbleSort(array: Array<T>): Array<T> {
    for (order in array.size downTo 0) {
        for (i in 0 until order) {
            if (array[i] > array[i+1]) {
                array.swap(i, i+1)
            }
        }
    }
    return array
}

fun <T: Comparable<T>> selectSort(array: Array<T>): Array<T> {
    for (order in 0 until array.size) {
        var minIndex = order
        for (i in order until array.size) {
            if (array[i] < array[minIndex]) minIndex = i
        }
        array.swap(minIndex, order)
    }
    return array
}

fun <T: Comparable<T>> insertSort(array: Array<T>): Array<T> {
    for (i in 1 until array.size) {
        var j = i - 1
        val key = array[i]
        while (j >= 0 && array[j] > key) {
            array[j+1] = array[j]
            j = j-1
        }
        array[j+1] = key
    }
    return array
}

fun <T: Comparable<T>> gapInsertSort(array: Array<T>, start: Int, gap: Int) {
    for (target in start+gap until array.size step gap) {
        val value = array[target]
        var i = target
        while (i > start) {
            if (array[i-gap] > value) array[i] = array[i-gap] else break
            i -= gap
        }
        array[i] = value
    }
}

fun <T: Comparable<T>> shellSort(array: Array<T>): Array<T> {
    var gap = array.size / 2
    while (gap > 0) {
        for (start in 0 until gap) {
            gapInsertSort(array, start, gap)
            gap /= 2
        }
    }
    return array
}

// A: input array
// k: maximum value of A
fun countingSort(A: Array<Int>, k: Int): Array<Int> {
    // B: output array
    // init with -1
    val B = Array(A.size) { -1 }

    // C: counting array
    // init with zeros
    val C = Array(k + 1) { 0 }

    // count occurences
    for (a in A) {
        C[a]++
    }

    // update C
    for (i in 0 until k) {
        C[i+1] += C[i]
    }

    // update B
    for (j in A.size - 1 downTo 0) {
        B[C[A[j]] - 1] = A[j]
        C[A[j]]--
    }
    return B
}

fun Array<Int>.mergeSort(start: Int, end: Int): Array<Int> {
    if (start + 1 == end) return Array(1) { this[start] }
    val mid = (start + end) / 2
    val left = mergeSort(start, mid)
    val right = mergeSort(mid, end)
    return merge(left, right)
}

fun merge(left: Array<Int>, right: Array<Int>): Array<Int> {
    var i = 0
    var j = 0
    val sizeL = left.size
    val sizeR = right.size
    val sortedList = Array(sizeL + sizeR) { 0 }
    var index = 0
    while (i < sizeL && j < sizeR) {
        when {
            left[i] < right[j] -> sortedList[index++] = left[i++]
            else -> sortedList[index++] = right[j++]
        }
    }
    while (i < sizeL) sortedList[index++] = left[i++]
    while (j < sizeR) sortedList[index++] = right[j++]
    return sortedList
}

fun main() {
    val prev = intArrayOf(5, 4, 3, 7, 8, 2).toTypedArray()
    val new = prev.mergeSort(0, prev.size)
    println(new.contentToString())
}

fun <T: Comparable<T>> Array<T>.quickSort(left: Int, right: Int) {
    if (left < right) {
        val pivot = this.partitionArray(left, right)
        quickSort(pivot+1, right)
        quickSort(left, pivot-1)
    }
}

fun <T: Comparable<T>> Array<T>.partitionArray(left: Int, right: Int): Int {
    val pivot = this[right]
    var i = left - 1
    for (j in left until right) {
        if (this[j] <= pivot) {
            i++
            swap(i, j)
        }
    }
    swap(i+1, right)
    return i + 1
}

tailrec fun <T: Comparable<T>> Array<T>.heapify(index: Int = 0, heapSize: Int = size) {
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
    for (i in size/ 2 downTo 0) {
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

fun <T: Comparable<T>> Array<T>.heapSort() {
    val n = size
    for (i in n/2 downTo 0 step 1) this.heapify(i, n)
    for (i in n-1 downTo 0 -1) {
        swap(0, i)
        heapify(0, i)
    }
}