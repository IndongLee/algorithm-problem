package Programmers.L2

private fun solution(name: String): Int {
    val N = name.length
    var answer = 0
    val m = Array(N) { diff(name[it]) }
    var cur = 0
    do {
        answer += m[cur]
        m[cur] = 0
        var left = if (cur != 0) cur - 1 else N - 1
        var leftDis = 1
        var right = if (cur != N - 1) cur + 1 else 0
        var rightDis = 1
        while (m[left] == 0 && left != cur) {
            if (left == 0) left = N - 1 else left--
            leftDis++
        }
        while (m[right] == 0 && right != cur) {
            if (right == N - 1) right = 0 else right++
            rightDis++
        }
        if (cur == left && cur == right) break
        if (leftDis < rightDis) {
            cur = left
            answer += leftDis
        } else {
            cur = right
            answer += rightDis
        }
    } while (true)

    return answer
}

val diff = {c: Char ->
    val diffA = c.toInt() - 65
    val diffa = 91 - c.toInt()
    if (diffA < diffa) diffA else diffa
}

fun main() {
    println(solution("BBAAAAAAAABB"))
}