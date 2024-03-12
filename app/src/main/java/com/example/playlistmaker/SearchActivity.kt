package com.example.playlistmaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.core.widget.addTextChangedListener

class SearchActivity : AppCompatActivity() {


    private var textValue = "SEARCH_TEXT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val arrowBack = findViewById<ImageView>(R.id.arrowBack)
        val inputEditText = findViewById<EditText>(R.id.editTextSearch)
        val clearButton = findViewById<ImageView>(R.id.clearButton)

        arrowBack.setOnClickListener {
            finish()
        }

        clearButton.setOnClickListener {
            inputEditText.setText("")
        }

        if (savedInstanceState != null) {
            inputEditText.setText(savedInstanceState.getString(KEY_OF_TEXT))
        }

        val searchTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // empty
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                clearButton.visibility = buttonVisibility(s)
            }

            override fun afterTextChanged(s: Editable?) {
                textValue = s.toString()
            }
        }
        inputEditText.addTextChangedListener(searchTextWatcher)
    }

    private fun buttonVisibility(s: CharSequence?): Int{
        return if (s.isNullOrEmpty()) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_OF_TEXT, textValue)
    }

    companion object {
        const val KEY_OF_TEXT = "FIRST_KEY"
    }

}