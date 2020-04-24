package Programmers.L2

private fun solution(s: String): String {
    var answer = ""
    return s.split(" ").fold("") { acc, word ->
        acc + "${word.toLowerCase().capitalize()} "
    }.trim()
}