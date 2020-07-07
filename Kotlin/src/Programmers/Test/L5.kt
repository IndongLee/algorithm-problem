package Programmers.Test

import kotlin.math.min

private fun solution(dataSource: Array<Array<String>>, tags: Array<String>): Array<String> {
    var answer = arrayOf<String>()
    val setTags = tags.toHashSet()
    val check = Array(dataSource.size) { Array(2) { "" } }
    for (i in dataSource.indices) {
        var count = 0
        for (j in 1 until dataSource[i].size) {
            if (setTags.contains(dataSource[i][j])) count++
        }
        check[i][0] = dataSource[i][0]
        check[i][1] = count.toString()
    }
    check.sortWith(kotlin.Comparator { o1, o2 ->
        when {
            o1[1] > o2[1] -> -1
            o1[1] < o2[1] -> 1
            else -> {
                var value = 0
                for (i in 0 until min(o1[0].length, o2[0].length)) {
                    if (o1[0][i] < o2[0][i]) {
                        value = -1
                        break
                    }
                    else if (o1[0][i] > o2[0][i]) {
                        value = 1
                        break
                    }
                }
                when(value) {
                    0 -> {
                        when {
                            o1[0].length < o2[0].length -> -1
                            o1[0].length > o2[0].length -> 1
                            else -> 0
                        }
                    }
                    else -> value
                }
            }
        }
    })
    println(check.contentDeepToString())
    val result = check.filter { it[1].toInt() > 0 }.map { it[0] }
    return if (result.size > 10) result.take(10).toTypedArray() else result.toTypedArray()
}