// MainActivity.kt
package com.example.baitap1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        // Lấy các View từ layout
        val ivProfilePicture = findViewById<ImageView>(R.id.ivProfilePicture)
        val tvUserName = findViewById<TextView>(R.id.tvUserName)
        val tvUserLocation = findViewById<TextView>(R.id.tvUserLocation)

        // Thiết lập thông tin người dùng
        tvUserName.text = "Tán Hoàng Minh Khôi"
        tvUserLocation.text = "Xuân Thọ, Đà Lạt"
    }
}