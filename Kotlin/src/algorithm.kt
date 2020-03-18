import java.util.*

//class Node<T>(val data: T, var left: Node<T>? = null, var right: Node<T>? = null)


sealed class Node<out T> {
    class Value<T>(val value: T, var left: Node<T> = EmptyNode, var right: Node<T> = EmptyNode) : Node<T>()
    object EmptyNode : Node<Nothing>()
}

class BinarySearchTree<T> where T : Comparable<T> {
    private var root: Node<T>

    constructor() {
        root = Node.EmptyNode
    }

    constructor(newValue: T) {
        root = Node.Value(newValue)
    }

    fun insert(data: T) {
        root = insertData(root, data)
        if (root == Node.EmptyNode) throw Exception("Insert Error")
    }

    private fun insertData(node: Node<T>, data: T): Node<T> = when (node) {
        Node.EmptyNode -> Node.Value(data)
        is Node.Value -> {
            if (data <= node.value) node.left = insertData(node.left, data)
            else node.right = insertData(node.right, data)
            node
        }
    }


    fun delete(value: T) {
        root = deleteData(root, value)
    }

    private fun deleteData(node: Node<T>, data: T): Node<T> = when (node) {
        Node.EmptyNode -> Node.EmptyNode
        is Node.Value -> {
            if (data < node.value) {
                node.left = deleteData(node.left, data)
                node
            }
            else if (data > node.value) {
                node.right = deleteData(node.right, data)
                node
            }
            else {
                when {
                    node.left is Node.Value && node.right == Node.EmptyNode -> node.left
                    node.left == Node.EmptyNode && node.right is Node.Value -> node.right
                    node.left == Node.EmptyNode && node.right == Node.EmptyNode -> Node.EmptyNode
                    else -> {
                        var parent: Node.Value<T> = node
                        var child = node.right as Node.Value<T>
                        while (child.left is Node.Value) {
                            parent = child
                            child = child.left as Node.Value<T>
                        }
                        child.left = node.left
                        if (parent != node) {
                            parent.left = child.right
                            child.right = node.right
                        }
                        child
                    }
                }
            }
        }
    }

    tailrec fun find(target: T, node: Node<T> = root): Boolean = when (node) {
        Node.EmptyNode -> false
        is Node.Value -> when {
            target < node.value -> find(target, node.left)
            target > node.value -> find(target, node.right)
            target == node.value -> true
            else -> false
        }
    }

    fun treeSize(node: Node<T> = root): Int = when (node) {
        Node.EmptyNode -> 0
        is Node.Value -> 1 + treeSize(node.left) + treeSize(node.right)
    }

    fun proOrderTraversal(node: Node<T> = root): Unit = when (node) {
        Node.EmptyNode -> {}
        is Node.Value -> {
            println(node.value)
            proOrderTraversal(node.left)
            proOrderTraversal(node.right)
        }
    }

    fun inOrderTraversal(node: Node<T> = root): Unit = when (node) {
        Node.EmptyNode -> {}
        is Node.Value -> {
            inOrderTraversal(node.left)
            println(node.value)
            inOrderTraversal(node.right)
        }
    }

    fun postOrderTraversal(node: Node<T> = root): Unit = when (node) {
        Node.EmptyNode -> {}
        is Node.Value -> {
            postOrderTraversal(node.left)
            postOrderTraversal(node.right)
            println(node.value)
        }
    }

    fun levelOrderTraversal(node: Node<T> = root): Unit {
        val queue: Queue<Node<T>> = LinkedList()
        queue.add(node)
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            when (cur) {
                Node.EmptyNode -> {}
                is Node.Value -> {
                    println(cur.value)
                    queue.add(cur.left)
                    queue.add(cur.right)
                }
            }
        }

    }
}

fun main() {
    val bst = BinarySearchTree(5)
    bst.insert(3)
    bst.insert(7)
    bst.insert(2)
    bst.insert(4)
    bst.proOrderTraversal()
    println("=============")
    bst.inOrderTraversal()
    println("=============")
    bst.levelOrderTraversal()
}




