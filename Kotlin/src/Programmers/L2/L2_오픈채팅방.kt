package Programmers.L2

private fun solution(record: Array<String>): Array<String> {
    val userMap = hashMapOf<String, String>()
    val command = mapOf("Enter" to "들어왔습니다.", "Leave" to "나갔습니다.")
    return record.map {
            val rec = it.split(" ")
            if (rec.size == 3) userMap[rec[1]] = rec[2]
            Pair(rec[1], rec[0])
        }.asSequence().filter { it.second[0] != 'C' }
        .map { "${userMap[it.first]}님이 ${command[it.second]}" }.toList().toTypedArray()
}

fun main() {
    println(
        solution(
            arrayOf(
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
            )
        ).contentToString())
}