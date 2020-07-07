package Programmers.Test

import kotlin.math.max

private fun solution(answer_sheet: String, sheets: Array<String>): Int {
    var answer = 0
    for (i in sheets.indices) {
        for (j in i+1 until sheets.size) {
            var count = 0
            var len = arrayListOf<Int>()
            var index = -1
            var flag = false
            for (k in answer_sheet.indices) {
                if (sheets[i][k] == sheets[j][k] && sheets[i][k] != answer_sheet[k]) {
                    count++
                    if (flag) {
                        len[index]++
                    } else {
                        len.add(1)
                        index++
                        flag = true
                    }
                } else {
                    flag = false
                }
            }
            val maxLen = if (len.isEmpty()) 0 else len.max()
            answer = max(answer, count + (maxLen!! * maxLen!!))
        }
    }
    return answer
}