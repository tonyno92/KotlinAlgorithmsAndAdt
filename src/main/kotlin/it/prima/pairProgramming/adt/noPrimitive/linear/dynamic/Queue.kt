package it.prima.pairProgramming.adt.noPrimitive.linear.dynamic

/**
 * Non-Primitive - Linear - Dynamic
 */
class Queue(size: Int) {
    private val queue = Array(size) { Int.MIN_VALUE }
    private var tail = 0

    fun enqueue(value: Int): Boolean {
        if (tail == queue.size) return false
        queue[tail++] = value
        //queue[tail] = value;
        // tail++
        return true
    }

    fun dequeue(): Int? {
        if (tail <= 0) return null
        val deleted = queue.first()
        tail--
        for (i in 0 until tail)
        //for (i in 0 until --tail)
            queue[i] = queue[i + 1]
        return deleted
    }

    fun peak() = queue.firstOrNull()

    fun getQueue() = queue

}