package Programmers.L2

private fun solution(p: String): String {
    return changeBracket(p)
}

fun changeBracket(bracket: String): String {
    return if (bracket.isEmpty()) {
        bracket
    } else {
        val pivot = findPivot(bracket)
        val isCorrect = bracket[0] != ')'

        val u = bracket.take(pivot + 1)
        val v = changeBracket(bracket.takeLast(bracket.lastIndex - pivot))

        when(isCorrect) {
            true -> u + v
            false -> "($v)${u.drop(1).dropLast(1).asSequence().map{ if (it == '(') ')' else '(' }.joinToString("")}"
        }
    }

}

fun findPivot(bracket: String): Int {
    var left = 0
    var right = 0
    for (i in bracket.indices) {
        when (bracket[i]) {
            '(' -> left++
            ')' -> right++
        }
        if (left != 0 && right != 0 && left == right) {
            return i
        }
    }
    return bracket.length
}


fun main() {
    println(solution("()))((()"))
}