package com.imagina.calculadorahipoteca


import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.imagina.calculadorahipoteca.Constants.Companion.AMOUNT_VALUE
import com.imagina.calculadorahipoteca.Constants.Companion.RATE_VALUE
import com.imagina.calculadorahipoteca.Constants.Companion.YEARS_VALUE
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dec = NumberFormat.getNumberInstance(Locale.getDefault())
        val dfRate = DecimalFormat("0.00")

        sbAmount.progress = 10
        textAmount.setText(dec.format(150000))
        sbRate.progress = 20
        textRate.setText(dfRate.format(1.00).toString())
        sbYears.progress = 5
        textYears.setText(R.string.starter_amount)

        sbAmount.setOnSeekBarChangeListener(object : OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val amount = seekBar.progress * 10000 + 50000
                textAmount.setText(dec.format(amount))
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) { // empty Function
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {// empty Function
            }
        })

        sbRate.setOnSeekBarChangeListener(object: OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val rate:Double = seekBar.progress.toDouble() / 20

                textRate.setText(dfRate.format(rate).toString())
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) { // empty Function
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) { // empty Function
            }
        })

        sbYears.setOnSeekBarChangeListener(object: OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val rate = seekBar.progress + 10
                textYears.setText(rate.toString())
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) { // empty Function
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) { // empty Function
            }
        })


        bEvaluate.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(AMOUNT_VALUE, dec.parse(textAmount.text.toString())?.toInt())
            intent.putExtra(RATE_VALUE, textRate.text.toString().toDouble())
            intent.putExtra(YEARS_VALUE, textYears.text.toString().toInt())
            startActivity(intent)
        }
    }
}
