package com.example.playlistmaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val search = findViewById<Button>(R.id.search)
        val library = findViewById<Button>(R.id.library)
        val settings = findViewById<Button>(R.id.settings)

        search.setOnClickListener {
            val searchIntent = Intent(this, SearchActivity::class.java)
        }

        library.setOnClickListener {
            val libIntent = Intent(this, LibraryActivity::class.java)
            startActivity(libIntent)
        }

        settings.setOnClickListener{
            val settingsIntent = Intent(this, SettingsActivity::class.java)
            startActivity(settingsIntent)
        }


    }
}