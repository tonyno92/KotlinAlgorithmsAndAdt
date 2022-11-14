package it.prima.pairProgramming.adt.noPrimitive.noLinear

import java.util.Stack


class Graph<NODE> private constructor() {

    //var graph = LinkedHashMap<NODE, MutableList<NODE>>()
    /**
     * Rappresents a graph like a adjcents list
     */
    lateinit var graph: Map<NODE, List<NODE>>

    /**
     * Input Example : [[1, 2], [1, 3], [1, 4], [2, 4], [2, 5], [3, 6], [4, 3], [4,6], [4, 7], [5, 4], [5, 7], [7, 6]]
     */
    constructor(edges: Array<Pair<NODE, NODE>>, directional: Boolean = true) : this() {
        graph = LinkedHashMap<NODE, MutableList<NODE>>()
            .apply {
                edges.onEach { edge ->
                    if (!containsKey(edge.first))
                        put(edge.first, mutableListOf(edge.second))
                    else
                        this[edge.first]?.add(edge.second)

                    if (!directional && !containsKey(edge.second))
                        put(edge.second, mutableListOf(edge.first))
                    else if (!directional) this[edge.second]?.add(edge.first)
                }
            }
    }

    fun bfs(startNode: NODE? = null) {
        println("Breath First Search")

        val visited = mutableListOf<NODE>()
        val queue = ArrayDeque<NODE>()
        val begin = startNode ?: graph.keys.first()
        queue.addLast(begin)

        while (queue.isNotEmpty()) {
            println("Queue : $queue - Visit : $visited")
            val node = queue.removeFirst()
            if (!visited.contains(node)) {
                visited.add(node)
                graph[node]?.forEach { adjacent ->
                    queue.addLast(adjacent)
                }
            }
        }
        println("Queue : $queue - Visit : $visited")
    }

    fun dfs(startNode: NODE? = null) {
        println("Deep First Search")
        val visited = mutableListOf<NODE>()
        val stack = Stack<NODE>()
        val begin = startNode ?: graph.keys.first()
        stack.push(begin)

        while (stack.isNotEmpty()) {
            println("Stack : $stack - Visit : $visited")
            val node = stack.pop()
            if (!visited.contains(node)) {
                visited.add(node)
                graph[node]?.forEach { adjacent ->
                    stack.push(adjacent)
                }
            }
        }
        println("Stack : $stack - Visit : $visited")
    }
}