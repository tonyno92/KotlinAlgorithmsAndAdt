package it.prima.pairProgramming.adt.noPrimitive.linear.dynamic

/**
 * Non-Primitive - Linear - Dynamic
 */
class Stack(size: Int) {
    private val stack = Array(size) { Int.MIN_VALUE }
    private var top = 0

    fun push(value: Int): Boolean {
        if (top >= stack.size) return false
        stack[top++] = value
        return true
    }

    fun pop(): Int? {
        if (top <= 0) return null
        val poped = stack[--top]
        stack[top] = Int.MIN_VALUE
        return poped
    }

    fun peak() = stack[top - 1]

    fun getStack() = stack

}