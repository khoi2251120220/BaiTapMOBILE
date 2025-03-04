package com.example.baitaptuan2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.baitaptuan2.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to UI elements
        val nameInput = findViewById<EditText>(R.id.nameInput)
        val ageInput = findViewById<EditText>(R.id.ageInput)
        val checkButton = findViewById<Button>(R.id.checkButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        // Set click listener for the button
        checkButton.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val ageStr = ageInput.text.toString().trim()

            if (name.isEmpty() || ageStr.isEmpty()) {
                resultText.text = "Vui lòng nhập đầy đủ thông tin!"
                return@setOnClickListener
            }

            try {
                val age = ageStr.toInt()

                val result = when {
                    age > 65 -> "$name thuộc nhóm Người già (>65)"
                    age in 16..65 -> "$name thuộc nhóm Người lớn (16-65)"
                    age in 2..6 -> "$name thuộc nhóm Trẻ em (2-6)"
                    age < 2 -> "$name thuộc nhóm Em bé (<2)"
                    else -> "Tuổi không thuộc nhóm nào!"
                }

                resultText.text = result
            } catch (e: NumberFormatException) {
                resultText.text = "Vui lòng nhập tuổi hợp lệ (số nguyên)!"
            }
        }
    }
}