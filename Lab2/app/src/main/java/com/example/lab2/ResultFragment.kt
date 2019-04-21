package com.example.lab2

import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.TextView

class ResultFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)

        val view: View = inflater.inflate(R.layout.result_fragment, container, false)

        if (this.arguments == null) {
            return view
        }

        val flowerNameText = this.arguments!!.getString("flowerNameInput")
        val colorsSpinnerText = this.arguments!!.getString("colorsSpinner")
        val seekBarValue = this.arguments!!.getString("seekBarValue")

        val flowerNameInput = view.findViewById<TextView>(R.id.flowerName)
        val flowerColorInput = view.findViewById<TextView>(R.id.flowerColor)
        val flowerPriceInput = view.findViewById<TextView>(R.id.flowerPrice)

        flowerNameInput.text = flowerNameText
        flowerColorInput.text = colorsSpinnerText
        flowerPriceInput.text = seekBarValue

        return view
    }
}