package com.example.home_work111

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var passengerCount = 0
    private val maxPassengers = 50
    private lateinit var passengerCountText: TextView
    private lateinit var remainingSeatsText: TextView
    private lateinit var btnIncrease: Button
    private lateinit var btnDecrease: Button
    private lateinit var btnReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        passengerCountText = findViewById(R.id.passengerCountText)
        remainingSeatsText = findViewById(R.id.remainingSeatsText)
        btnIncrease = findViewById(R.id.btnIncrease)
        btnDecrease = findViewById(R.id.btnDecrease)
        btnReset = findViewById(R.id.btnReset)

        updateUI()

        btnIncrease.setOnClickListener {
            if (passengerCount < maxPassengers) {
                passengerCount++
                updateUI()
            }
        }

        btnDecrease.setOnClickListener {
            if (passengerCount > 0) {
                passengerCount--
                updateUI()
            }
        }

        btnReset.setOnClickListener {
            passengerCount = 0
            btnReset.visibility = View.GONE
            updateUI()
        }
    }

    private fun updateUI() {
        passengerCountText.text = passengerCount.toString()

        when {
            passengerCount < maxPassengers -> {
                remainingSeatsText.text = "Осталось мест: ${maxPassengers - passengerCount}"
                remainingSeatsText.setTextColor(Color.BLUE)
                btnReset.visibility = View.GONE
                btnIncrease.isEnabled = true
                btnDecrease.isEnabled = true
            }
            passengerCount >= maxPassengers -> {
                remainingSeatsText.text = "Пассажиров слишком много!"
                remainingSeatsText.setTextColor(Color.RED)
                btnReset.visibility = View.VISIBLE
                btnIncrease.isEnabled = false
                btnDecrease.isEnabled = false
            }
            else -> {
                remainingSeatsText.setTextColor(Color.GREEN)
                btnReset.visibility = View.GONE
                btnIncrease.isEnabled = true
                btnDecrease.isEnabled = true
            }
        }
    }
}