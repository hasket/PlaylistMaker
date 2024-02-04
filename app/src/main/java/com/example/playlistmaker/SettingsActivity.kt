package com.example.playlistmaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val backArray = findViewById<ImageView>(R.id.arrowBack)

        backArray.setOnClickListener{
            val backIntent = Intent(Intent.ACTION_USER_BACKGROUND)
            startActivity(backIntent)
        }

    }
}