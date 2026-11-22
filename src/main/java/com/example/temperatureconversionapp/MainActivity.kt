package com.example.temperatureconversionapp

// Name: Kerri Kuhnke
// Date: November 22, 2026
// Assignment: Temperature Conversion Application

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.temperatureconversionapp.R
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtTemperature =
            findViewById<EditText>(R.id.txtTemperature)

        val radFtoC =
            findViewById<RadioButton>(R.id.radFtoC)

        val radCtoF =
            findViewById<RadioButton>(R.id.radCtoF)

        val btnConvert =
            findViewById<Button>(R.id.btnConvert)

        val txtResult =
            findViewById<TextView>(R.id.txtResult)

        val decimalFormat = DecimalFormat("0.0")

        btnConvert.setOnClickListener {

            val input = txtTemperature.text.toString()

            if (input.length == 0) {
                Toast.makeText(
                    this,
                    "Please enter a temperature.",
                    Toast.LENGTH_LONG
                ).show()

                txtResult.text = "--"

            } else {

                val temperature = try {
                    java.lang.Double.parseDouble(input)
                } catch (e: NumberFormatException) {
                    null
                }

                if (temperature == null ||
                    java.lang.Double.isNaN(temperature) ||
                    java.lang.Double.isInfinite(temperature)) {

                    Toast.makeText(
                        this,
                        "Please enter a valid temperature.",
                        Toast.LENGTH_LONG
                    ).show()

                    txtResult.text = "--"

                } else if (radFtoC.isChecked) {

                    if (temperature < -100 || temperature > 250) {

                        Toast.makeText(
                            this,
                            "Fahrenheit must be between -100 and 250.",
                            Toast.LENGTH_LONG
                        ).show()

                        txtResult.text = "--"

                    } else {

                        val celsius = (temperature - 32) * 5 / 9

                        txtResult.text =
                            decimalFormat.format(celsius) + " °C"
                    }

                } else if (radCtoF.isChecked) {

                    if (temperature < -75 || temperature > 125) {

                        Toast.makeText(
                            this,
                            "Celsius must be between -75 and 125.",
                            Toast.LENGTH_LONG
                        ).show()

                        txtResult.text = "--"

                    } else {

                        val fahrenheit =
                            (temperature * 9 / 5) + 32

                        txtResult.text =
                            decimalFormat.format(fahrenheit) + " °F"
                    }
                }
            }
        }
    }
}
