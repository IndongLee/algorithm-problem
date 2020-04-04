package BOJ

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arrays = Array(4) { IntArray(n) }
    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        for (j in 0..3) {
            arrays[j][i] = st.nextToken().toInt()
        }
    }

    val left = IntArray(n * n)
    val right = IntArray(n * n)
    for (i in 0 until n) {
        for (j in 0 until n) {
            val index = i * n + j
            left[index] = arrays[0][i] + arrays[1][j]
            right[index] = arrays[2][i] + arrays[3][j]
        }
    }

    left.sort()
    right.sort()
    var start = 0
    var end = n * n - 1
    var res = 0L
    while (start < n * n && end >= 0) {
        when {
            -left[end] == right[start] -> {
                var leftCount = 0L
                var rightCount = 0L
                val temp = right[start]
                while (end >= 0 && -left[end] == temp) {
                    leftCount++
                    end--
                }
                while (start < n * n && right[start] == temp) {
                    rightCount++
                    start++
                }

                res += leftCount * rightCount
            }
            -left[end] < right[start] -> end--
            else -> start++
        }
    }
    println(res)
}