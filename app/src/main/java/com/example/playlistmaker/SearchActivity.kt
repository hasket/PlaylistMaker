package com.example.playlistmaker

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.widget.addTextChangedListener

class SearchActivity : AppCompatActivity() {


    private var textValue = STATE_OF_TEXT


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val inputEditText = findViewById<EditText>(R.id.editTextSearch)
        val arrowBack = findViewById<ImageView>(R.id.arrowBack)
        val clearButton = findViewById<ImageView>(R.id.clearButton)

        arrowBack.setOnClickListener {
            finish()
        }

        clearButton.setOnClickListener {
            val searchActivity = this.currentFocus
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(searchActivity?.windowToken, 0)
            inputEditText.setText("")
        }

        if (savedInstanceState != null) {
            inputEditText.setText(textValue)
        }

        val searchTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

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

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textValue = savedInstanceState.getString(KEY_OF_TEXT, STATE_OF_TEXT)
    }

     companion object {
        private const val KEY_OF_TEXT = "FIRST_KEY"
        private const val STATE_OF_TEXT = "STATE"
    }

}