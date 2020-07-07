package LeetCode.easy


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun getDecimalValue(head: ListNode?): Int {
    var binaryNum = 0
    var now = head
    while (now != null) {
        binaryNum = (binaryNum shl 1) or now.`val`
        now = now.next
    }
    return binaryNum
}

fun main() {

}