package com.example.lab3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.io.File
import java.io.IOException

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
                seekBarValue.text = getString(R.string.priceRange, 0, i)
            }
        })

        val okBtn = findViewById<Button>(R.id.okBtn)

        okBtn.setOnClickListener {
            val flowerNameInput = findViewById<EditText>(R.id.flowerName)
            val text = "${flowerNameInput.text}\n" +
                    "${colorsSpinner.selectedItem}\n" +
                    "${seekBarValue.text}"

            val directory = filesDir;

            try {
                val file = File(directory, "result.txt")

                file.createNewFile()
                file.writeText(text)
            } catch (e: IOException) {
                e.printStackTrace();
            }

            Toast.makeText(this, "Successfully written in file", Toast.LENGTH_LONG).show()
        }

        val openFileActibityBtn = findViewById<Button>(R.id.openFileBtn)

        openFileActibityBtn.setOnClickListener {
            val fileActivity = Intent(this, FileActivity::class.java)
            startActivity(fileActivity);
        }
    }
}
