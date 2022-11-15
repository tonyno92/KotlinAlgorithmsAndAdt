package it.prima.pairProgramming.ui.exercise

class MergeSort {

    lateinit var unsorted: List<Int>

    fun mergeSort(): List<Int> {
        return divide(unsorted)
    }

    private fun divide(list: List<Int>): List<Int> {
        if (list.size <= 1)
            return list
        val middle = list.size / 2
        val left = list.subList(0, middle)
        val right = list.subList(middle, list.size)

        return impera(divide(left), divide(right))
    }

    private fun impera(left: List<Int>, right: List<Int>): List<Int> {
        var indexLeft = 0
        var indexRight = 0
        val result = mutableListOf<Int>()

        while (indexLeft < left.count() && indexRight < right.count()) {
            if (left[indexLeft] <= right[indexRight]) {
                result.add(left[indexLeft++])
            } else
                result.add(right[indexRight++])
        }

        while (indexLeft < left.size) result.add(left[indexLeft++])
        while (indexRight < right.size) result.add(right[indexRight++])

        return result
    }

}