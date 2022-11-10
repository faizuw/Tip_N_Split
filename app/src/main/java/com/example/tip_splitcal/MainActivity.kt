package com.example.tip_splitcal

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

public const val initialValue = 0

class MainActivity : AppCompatActivity() {
    lateinit var billAmount: EditText
    lateinit var tipAmount: EditText
    lateinit var totalAmount: TextView
    lateinit var split: TextView
    lateinit var minus: Button
    lateinit var plus: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //To hide tile and action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

//        getSupportActionBar()?.hide();

        setContentView(R.layout.activity_main)
        var num = 0
        billAmount = findViewById(R.id.idBill)
        tipAmount = findViewById(R.id.idtip)
        totalAmount = findViewById(R.id.totalAmount)
        split = findViewById(R.id.idPeople)
        minus = findViewById(R.id.idMinus)
        plus = findViewById(R.id.idPlus)

        minus.setOnClickListener {

                num=1
            if (num > 1) {
                num--
            }

            split.text = num.toString()

        }
        plus.setOnClickListener {
            if (num < 20) {
                num++
            }

            split.text = num.toString()

        }


        billAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                calulateTotal()
            }
        })
        tipAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

                calulateTotal()
            }
        })
        split.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

                calulateTotal()
            }
        })

    }

    private fun calulateTotal() {

        val bill =
            if (billAmount.text.toString().isEmpty()) 0.0 else billAmount.text.toString().toDouble()
        val tip =
            if (tipAmount.text.toString().isEmpty()) 0.0 else tipAmount.text.toString().toDouble()
        var total = bill + tip
//        if (!billAmount.text.isEmpty() && !tipAmount.text.isEmpty()) {
//            total = billAmount.text.toString().toDouble() + tipAmount.text.toString().toDouble()
//            total = total / split.text.toString().toInt()
//        }
        total = total / split.text.toString().toInt()
        totalAmount.text = "%.2f".format(total)


    }
}
