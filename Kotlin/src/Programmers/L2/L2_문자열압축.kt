package Programmers.L2

private fun solution(s: String): Int {
    val len = s.length
    var answer = len
    for (i in 1..len) {
        var sub = s.substring(0, i)
        var count = 1
        val comp = StringBuilder()
        for (j in i until len step i) {
            val next = if (j + i > len) s.substring(j, len) else s.substring(j, j + i)
            if (sub == next) count++
            else {
                if (count > 1) comp.append(count)
                comp.append(sub)
                sub = next
                count = 1
            }
        }
        if (count > 1) comp.append(count)
        comp.append(sub)

        val compWord = comp.toString().length
        if (compWord < answer) answer = compWord
    }
    return answer
}

fun main() {
    println(solution("aabbaccc"))
}
