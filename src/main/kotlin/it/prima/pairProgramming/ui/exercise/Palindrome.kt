package it.prima.pairProgramming.ui.exercise

import it.prima.pairProgramming.ext.digit


class Palindrome {

    /**
     * Given an integer, return true if the integer is a palindrome.
     *
     */
    var num: Int = 0
    private var backup: Int = 0

    fun readInt(): Int {
        print("Read Integer # : ")
        num = readln().toIntOrNull() ?: num
        return num
    }

    /**
     * Tip : retrive each digit and make them in inverse orders
     * (num % 10) -> retive the digit
     *
     */
    fun isPalindrome() {
        println("Checking...")
        backup = num

        var inverse: Int = 0
        while (num > 0) {
            //val digit = num % 10
            inverse = inverse * 10 + num.digit()
            num /= 10
        }

        println("$backup is palindrome :  ${if (backup == inverse) "Yes" else "No"}")
    }

}
