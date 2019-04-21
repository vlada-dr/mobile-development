package com.example.lab1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private val FLOWER_COLOR = arrayOf("Yellow", "Red", "White", "Blue", "Orange", "Multicolored")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorsSpinner = findViewById<Spinner>(R.id.spinner)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, FLOWER_COLOR
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        colorsSpinner.adapter = adapter

        val seekBar = findViewById<SeekBar>(R.id.priceSeekBar)
        val seekBarValue = findViewById<TextView>(R.id.priceSeekBarValue)
        seekBarValue.text = getString(R.string.priceRange, 0, 100)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                seekBarValue.text =getString(R.string.priceRange, 0, i)
            }
        })

        val okBtn = findViewById<Button>(R.id.okBtn)

        okBtn.setOnClickListener {
            val flowerNameInput = findViewById<EditText>(R.id.flowerName)
            val text = "${flowerNameInput.text}\n" +
                "${colorsSpinner.selectedItem}\n" +
                "${seekBarValue.text}"

            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        }
    }
}
