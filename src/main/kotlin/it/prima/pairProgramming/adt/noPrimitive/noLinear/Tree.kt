package it.prima.pairProgramming.adt.noPrimitive.noLinear

import java.util.*
import kotlin.collections.ArrayDeque

class Tree<T>(private val root: Node<T>) {

    fun preOrder(root: Node<T>? = this.root) {
        if (root != null) {
            print("${root.value} ")
            preOrder(root.left)
            preOrder(root.right)
        }
    }

    fun bfs(root: Node<T>? = this.root) {
        val visited = mutableListOf<Node<T>?>()
        val queue = ArrayDeque<Node<T>?>()

        queue.addLast(root)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (!visited.contains(node)) {
                print("${node?.value ?: ""} ")
                queue.addLast(node?.left)
                queue.addLast(node?.right)
                visited.add(node)
            }
        }
        println()
    }

    fun dfs(root: Node<T>? = this.root) {
        val visited = mutableListOf<Node<T>?>()
        val stack = Stack<Node<T>?>()

        stack.push(root)
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            if (!visited.contains(node)) {
                print("${node?.value ?: ""} ")
                stack.push(node?.right)
                stack.push(node?.left)
                visited.add(node)
            }
        }
        println()
    }

    fun inOrder(root: Node<T>? = this.root) {
        if (root != null) {
            inOrder(root.left)
            print("${root.value} ")
            inOrder(root.right)
        }
    }

    fun postOrder(root: Node<T>? = this.root) {
        if (root != null) {
            postOrder(root.left)
            postOrder(root.right)
            print("${root.value} ")
        }
    }

}