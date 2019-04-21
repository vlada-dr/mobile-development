package com.example.lab3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.io.File
import java.io.IOException

class FileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file)

        val directory = filesDir

        try {
            val file = File(directory, "result.txt")
            val text = file.readText()
            val readFromFileTextView = findViewById<TextView>(R.id.readFromFileText)

            readFromFileTextView.text = text

        } catch (e: IOException) {
            Toast.makeText(this, "No file available", Toast.LENGTH_LONG).show()
            finish()
        }

        val backBtn = findViewById<Button>(R.id.backBtn)

        backBtn.setOnClickListener {
            finish()
        }
    }
}
