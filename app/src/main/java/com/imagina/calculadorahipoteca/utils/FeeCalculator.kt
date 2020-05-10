package com.imagina.calculadorahipoteca.com.imagina.calculadorahipoteca.utils

class FeeCalculator {
    companion object {
        fun calculateFee(amount: Int, rate: Double, time: Int): Double {
            val calcRate = rate / 1200

            val numerator = calcRate * Math.pow(1 + calcRate, time.toDouble())
            val denominator = Math.pow(1 + calcRate, time.toDouble()) - 1
            val fee = amount * (numerator / denominator)

            return fee
        }
    }
}