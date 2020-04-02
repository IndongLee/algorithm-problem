package Programmers.L3


private fun solution(n: Int, costs: Array<IntArray>): Int {
    val root = Array(n + 1) { it }
    val rank = Array(n + 1) { 1 }

    fun find(x: Int): Int {
        if (x == root[x]) return x
        root[x] = find(root[x])
        return root[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX == rootY) return false

        if (rank[rootX] < rank[rootY]) root[rootX] = rootY
        else {
            root[rootY] = rootX
            if (rank[rootX] == rank[rootY]) rank[rootX]++
        }

        return true
    }

    var answer = 0
    costs.sortedBy { it[2] }
        .forEach { if (union(it[0], it[1])) answer += it[2] }
    return answer
}