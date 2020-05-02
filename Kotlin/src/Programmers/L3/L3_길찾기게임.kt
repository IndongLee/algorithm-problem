package Programmers.L3

import java.util.*
import kotlin.collections.ArrayList

private class Node(val x: Int, val y: Int, val index: Int) {
    var leftChild: Node? = null
    var rightChild: Node? = null
}

private class BinarySearchTree(var root: Node? = null) {

    fun insert(node: Node? = root, newNode: Node): Node = when (node) {
        null -> newNode
        else -> {
            if (node.x >= newNode.x) node.leftChild = insert(node.leftChild, newNode)
            else node.rightChild = insert(node.rightChild, newNode)
            node
        }
    }

    fun proOrderTraversal(node: Node? = root): ArrayList<Int> = when (node) {
        null -> {
            arrayListOf()
        }
        else -> {
            arrayListOf<Int>().apply {
                add(node.index)
                addAll(proOrderTraversal(node.leftChild))
                addAll(proOrderTraversal(node.rightChild))
            }
        }
    }

    fun postOrderTraversal(node: Node? = root): ArrayList<Int> = when (node) {
        null -> {
            arrayListOf()
        }
        else -> {
            arrayListOf<Int>().apply {
                addAll(postOrderTraversal(node.leftChild))
                addAll(postOrderTraversal(node.rightChild))
                add(node.index)
            }
        }
    }
}

private fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
    val BST = BinarySearchTree()
    nodeinfo.mapIndexed { index, ints ->
        Node(ints[0], ints[1], index + 1)
    }.sortedByDescending { it.y }
        .forEach { BST.root = BST.insert(BST.root, it) }

    return arrayOf(BST.proOrderTraversal().toIntArray(), BST.postOrderTraversal().toIntArray())
}

fun main() {

}