package com.example.playlistmaker

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.widget.Button
import android.widget.ImageView

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val backArray = findViewById<ImageView>(R.id.arrowBack)

        val shareApp = findViewById<ImageView>(R.id.share)
        val supportApp = findViewById<ImageView>(R.id.support)
        val personAgreementApp = findViewById<ImageView>(R.id.personAgreement)

        shareApp.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            val courseLink = getString(R.string.courseLink)
            shareIntent.setType("text/plain")
            shareIntent.putExtra(Intent.EXTRA_TEXT, courseLink)
            startActivity(Intent.createChooser(shareIntent, null))
        }

        supportApp.setOnClickListener {
            val message = getString(R.string.subjectMail)
            val title = getString(R.string.messageToDevelop)
            val developerMail = getString(R.string.developerEmail)
            val supportIntent = Intent(Intent.ACTION_SENDTO)
            supportIntent.data = Uri.parse("mailto:")
            supportIntent.putExtra(Intent.EXTRA_SUBJECT, title)
            supportIntent.putExtra(Intent.EXTRA_EMAIL, developerMail)
            supportIntent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(supportIntent)
        }

        personAgreementApp.setOnClickListener {
            val agreementLink = getString(R.string.agreementLink)
            val personAgreementIntent = Intent(Intent.ACTION_WEB_SEARCH)
            personAgreementIntent.putExtra(SearchManager.QUERY, agreementLink)
            startActivity(personAgreementIntent)
        }

        backArray.setOnClickListener{
            finish()
        }

    }
}