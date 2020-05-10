package com.imagina.calculadorahipoteca


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.imagina.calculadorahipoteca.Constants.Companion.AMOUNT_VALUE
import com.imagina.calculadorahipoteca.Constants.Companion.RATE_VALUE
import com.imagina.calculadorahipoteca.Constants.Companion.YEARS_VALUE
import com.imagina.calculadorahipoteca.com.imagina.calculadorahipoteca.utils.FeeCalculator
import kotlinx.android.synthetic.main.activity_result.*
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*


class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val locale = Locale.getDefault()
        val currencySymbol = Currency.getInstance(locale).getSymbol()
        val nf = NumberFormat.getNumberInstance(locale)
        val dec = nf as DecimalFormat
        dec.applyPattern("#,##0.00")

        val amount = intent.getIntExtra(AMOUNT_VALUE, 100000)
        val rate = intent.getDoubleExtra(RATE_VALUE,1.0)
        val years = intent.getIntExtra(YEARS_VALUE, 10)

        val time = years * 12
        val fee = FeeCalculator.calculateFee(amount, rate, time)

        tvFeeResult.append(" " + dec.format(fee) + currencySymbol)
        tvTotalAmount.append(dec.format(fee * time) + currencySymbol)
        
        (1..5).forEach { i ->
            val newTextView = TextView(this)

            val newRate = rate-(i.toDouble()/10)
            newTextView.text = "${dec.format(newRate)} : ${dec.format(FeeCalculator.calculateFee(amount, newRate, time))} ${currencySymbol}"
            newTextView.textSize = 20.0.toFloat()
            newTextView.setPadding(40, 0, 40, 10)

            linearLayout.addView(newTextView)
        }
    }


}
