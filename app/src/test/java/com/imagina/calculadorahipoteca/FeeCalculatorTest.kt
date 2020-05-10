package com.imagina.calculadorahipoteca

import com.imagina.calculadorahipoteca.com.imagina.calculadorahipoteca.utils.FeeCalculator
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FeeCalculatorTest {
    @Test
    fun feeCalculationTest() {
        val feeCalculator = FeeCalculator()
        val fee = feeCalculator.calculateFee(150000, 1.0, 15*12)

        assertEquals(897.74, fee, 0.01)
    }
}
