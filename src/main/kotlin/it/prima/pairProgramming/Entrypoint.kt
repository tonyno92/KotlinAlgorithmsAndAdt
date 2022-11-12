package it.prima.pairProgramming

import it.prima.pairProgramming.ui.PairProgrammingApplication

fun main(args: Array<String>) =
    try {
        PairProgrammingApplication().bootstrap()
    } catch (e: Exception) {
        e.printStackTrace()
    }
