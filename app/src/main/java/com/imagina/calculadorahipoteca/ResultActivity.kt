package com.imagina.calculadorahipoteca


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.imagina.calculadorahipoteca.Constants.Companion.AMOUNT_VALUE
import com.imagina.calculadorahipoteca.Constants.Companion.RATE_VALUE
import com.imagina.calculadorahipoteca.Constants.Companion.YEARS_VALUE
import kotlinx.android.synthetic.main.activity_result.*
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val nf = NumberFormat.getNumberInstance(Locale.getDefault())
        val dec = nf as DecimalFormat
        dec.applyPattern("##.##")


        val amount = intent.getIntExtra(AMOUNT_VALUE, 100000)
        val rate = intent.getDoubleExtra(RATE_VALUE,1.0)
        val years = intent.getIntExtra(YEARS_VALUE, 10)

        val time = years * 12
        val calc_rate = rate / 1200

        val numerator = calc_rate * Math.pow(1 + calc_rate, time.toDouble())
        val denominator = Math.pow(1 + calc_rate, time.toDouble()) - 1
        val fee = amount * (numerator / denominator)

        tvFeeResult.append(" " + dec.format(fee) + "€")
    }
}
