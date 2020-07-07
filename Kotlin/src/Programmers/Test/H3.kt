package Programmers.Test

private fun solution(registered_list: Array<String>, new_id: String): String {
    var updated_id = new_id
    while (updated_id in registered_list) {
        val S = StringBuilder()
        val N = StringBuilder()
        updated_id.forEach {
            if (it in 'a'..'z') S.append(it)
            else N.append(it)
        }
        updated_id = "$S${if (N.isEmpty()) 1 else N.toString().toInt() + 1}"
    }
    return updated_id
}