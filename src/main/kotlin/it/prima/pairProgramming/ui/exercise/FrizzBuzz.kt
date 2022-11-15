package it.prima.pairProgramming.ui.exercise

import it.prima.pairProgramming.ext.digit

class FrizzBuzz {

    /**
     * WHAT IS FIZZBUZZ?
     *
     * FizzBuzz is a common coding task given during interviews that tasks candidates to write
     * a solution that prints integers one-to-N, labeling any integers divisible
     * by three as “Fizz,” integers divisible by five as “Buzz” and integers divisible by both
     * three and five as “FizzBuzz.”
     * Understanding how to solve it can help reinforce good coding practices.
     *
     */

    private var start = 1
    private var end = 10
    private val range: IntRange by lazy { start..end }

    init {
        println("FrizzBuzz")

        print("Read Start # : ")
        start = readln().toIntOrNull() ?: start
        print("Read End # : ")
        end = readln().toIntOrNull() ?: end

        if (start > end) throw Exception("End must be smaller than Start")

        println("Range = $range")

    }

    fun basicSolution() {
        println("Basic solution (not recommended)")

        range.forEach { num ->
            println("$num = " +
                    when {
                        isMultipleOf3(num) && isMultipleOf5(num) -> "FrizzBuzz"
                        isMultipleOf3(num) -> "Frizz"
                        isMultipleOf5(num) -> "Buzz"
                        else -> num
                    })
        }
    }

    /**
     * Tip : Using string concat instead of multiple time check
     *
     */
    fun betterSolution() {
        println("Better solution")
        val output = Array(range.last + 1) { "" }
        range.forEach { num ->

            if (isMultipleOf3(num)) output[num] += "Frizz"
            if (isMultipleOf5(num)) output[num] += "Buzz"
            if (output[num].isEmpty()) output[num] = "$num"

            println("$num = ${output[num]}")
        }
    }

    /**
     * Tip :  if a number is divisible for 15 then is multiple of 3 and 5 at same time
     *
     */
    fun seniorSolution() {
        println("Senior solution")
        range.forEach { num ->
            println("$num = " +
                    when {
                        num % 15 == 0 -> "FrizzBuzz"
                        (isMultipleOf3(num)) -> "Frizz"
                        (isMultipleOf5(num)) -> "Buzz"
                        else -> num
                    }
            )
        }
    }

    private fun isMultipleOf3(num: Int): Boolean {
        var x = num
        var sum = 0
        while (x > 0) {
            //sum += x % 10
            sum += x.digit()
            x /= 10
        }
        return sum % 3 == 0
    }

    private fun isMultipleOf5(num: Int): Boolean {
        return num % 5 == 0
    }
}
