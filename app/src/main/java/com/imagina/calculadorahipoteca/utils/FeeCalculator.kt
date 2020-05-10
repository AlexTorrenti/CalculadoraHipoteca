package com.imagina.calculadorahipoteca.com.imagina.calculadorahipoteca.utils

import kotlin.math.pow

class FeeCalculator {
    companion object {
        fun calculateFee(amount: Int, rate: Double, time: Int): Double {
            val calcRate = rate / 1200

            val numerator = calcRate * (1 + calcRate).pow(time.toDouble())
            val denominator = (1 + calcRate).pow(time.toDouble()) - 1

            return amount * (numerator / denominator)
        }
    }
}