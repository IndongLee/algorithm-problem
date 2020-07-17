package Programmers.L1

private fun solution(strings: Array<String>, n: Int): Array<String> {
    return strings.sortedWith(compareBy({ it[n] }, { it })).toTypedArray()
}