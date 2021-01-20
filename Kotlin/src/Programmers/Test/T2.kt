package Programmers.Test

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val addressList = makeAddressList(N)
    val result = intersectAddress(N, addressList)
    println(result)

}

fun makeAddressList(N: Int): List<List<String>> {
    val addressList = mutableListOf<List<String>>()
    for (i in 0 until N) {
        addressList.add(readLine()!!.split("."))
    }
    return addressList
}

fun intersectAddress(N: Int, addressList: List<List<String>>): String {
    var commonAddress = mutableListOf<String>()
    var index = 0
    outer@while (true) {
        val checkSet = mutableSetOf<String>()
        for (i in 0 until N) {
            if (addressList[i].size - 1 == index) {
                break@outer
            }
            checkSet.add(addressList[i][index])
        }
        if (checkSet.size != 1) {
            break@outer
        }
        index++
        commonAddress.add(checkSet.first())
    }
    return if (commonAddress.isEmpty()) "없음" else commonAddress.joinToString(separator = ".")
}