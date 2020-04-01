package Programmers.L4

private fun solution(k: Long, room_number: LongArray): LongArray {
    val parent = hashMapOf<Long, Long>()
    val answer = LongArray(room_number.size) { 0L }
    fun find(x: Long): Long {
        return if (!parent.containsKey(x)) {
            parent[x] = x + 1
            x + 1
        } else {
            parent[x] = find(parent[x]!!)
            parent[x]!!
        }
    }

    room_number.forEachIndexed { index, l ->
        answer[index] = find(l) - 1
    }
    return answer
}