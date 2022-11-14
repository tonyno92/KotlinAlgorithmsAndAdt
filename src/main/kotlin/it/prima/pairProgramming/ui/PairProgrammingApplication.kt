package it.prima.pairProgramming.ui

import it.prima.pairProgramming.adt.noPrimitive.linear.dynamic.Queue
import it.prima.pairProgramming.adt.noPrimitive.linear.dynamic.Stack
import it.prima.pairProgramming.adt.noPrimitive.noLinear.Node
import it.prima.pairProgramming.core.Application
import java.util.*

internal class PairProgrammingApplication : Application {

    override fun bootstrap() {
        //println(GetInfoCountryUseCase().invoke())
        println("Hello World!!")
        arrayVsList()

        sumArray()

        matrix()
        arrayAsStack()
        arrayAsQueue()

        sortingArrayWithComparable()
        sortingPairWithComparable()

        priorityQueue()

        val tree = Node(
            "Antonietta",
            left = Node(
                "Antonio",
                left = Node("Francesco")
            ),
            right = Node(
                "Sergio",
                left = Node("Mini-Chef")
            )
        )
        printTree(root = tree)
    }

    private fun printTree(root: Node<*>) {
        root.left?.run { printTree(this) }
        root.right?.run { printTree(this) }
        println(root.value)
    }

    private fun sortingArrayWithComparable() {
        val arrayInt = intArrayOf(5, 3, 1, 8, 5)
        val comparator = compareBy<Int>(
            { it != 5 }, // Remember false < true because false = 0 and true = 1
            { it }
        )
        printArray(arrayInt.sortedWith(comparator).toTypedArray())
    }

    private fun sortingPairWithComparable() {
        println("Sorting using comparable")

        val sortedValues = mutableListOf(1 to "a", 2 to "b", 7 to "c", 6 to "d", 5 to "c", 6 to "e")
        println(sortedValues)
        sortedValues.sortWith(compareBy({ it.second }, { it.first }))
        println(sortedValues)

    }

    private fun priorityQueue() {
        val arr = intArrayOf(2, 1, 3, 5, 0)

        val dequeed = mutableListOf<Int>()
        val comparator = { a: Int, b: Int ->
            b - a
        }
        println("Priority Queue")
        // Create a PriorityQueue pq where the maximum value Int has highest priority
        val maxPQ = PriorityQueue<Int>(comparator).apply {
            // Add 2, 1, 3 to the pq
            offer(2)
            add(1)
            offer(3)
            peek() // returns 3 but does not remove it from pq will be empty after 3 iterations
            while (isNotEmpty()) {
                dequeed.add(poll()) // returns 3, then 2, then 1
            }
        }

        printArray(dequeed.toTypedArray())
    }

    private fun arrayVsList() {
        println("Array Vs List")
        val list = listOf(1, 2, 3, 4)
        println("List")
        println(list)
        println("list[0] = 5 -> Generate an error it'is immutable")
        //list[0] = 5 Generate an error

        println("Array")
        val array = arrayOf(1, 2, 3, 4)
        printArray(array)
        println("array[0] = 5")
        array[0] = 5
        printArray(array)
    }

    private fun sumArray() {
        println("Sum Array from index down to start")
        val sumArray = arrayOf(1, 2, 3, 4).let { arr ->
            printArray(arr)
            Array(arr.size) { index ->
                arr.sliceArray(0..index).sum()
            }
        }
        printArray(sumArray)
    }

    private fun matrix() {
        println("Array 2D as Matrix")
        print2DArray(
            arrayOf(
                arrayOf(2, 4, 6),
                arrayOf(1, 3, 5)
            )
        )
    }

    private fun arrayAsStack() {
        println("Array as Stack")

        Stack(4).apply {
            val list = mutableListOf<Int?>()
            push(1)
            push(2)
            push(3)
            push(4)
            push(5)
            printArray(getStack())
            list.add(pop())
            list.add(pop())
            list.add(pop())
            list.add(pop())
            printArray(list.toTypedArray())
        }

    }

    private fun arrayAsQueue() {
        println("Array as Queue")
        val queue = Queue(4)
        val list = mutableListOf<Int?>()

        queue.apply {
            enqueue(1)
            enqueue(2)
            enqueue(3)
            enqueue(4)
            enqueue(5)
            printArray(getQueue())
            list.add(dequeue())
            list.add(dequeue())
            list.add(dequeue())
            list.add(dequeue())
            printArray(list.toTypedArray())
        }
    }

    private fun printArray(array: Array<*>) {
        print('[')
        for (i in array.indices.first until array.indices.last)
            print("${array[i]}, ")
        println("${array.last()}]")

        /*val iterator = array.iterator()
        print('[')
        while (iterator.hasNext()) {
            print(iterator.next())
            if (iterator.hasNext()) print(", ")
        }
        println(']')*/
    }

    private fun print2DArray(array: Array<Array<*>>) {
        for (rowIndex in array.indices) printArray(array[rowIndex])
    }
}