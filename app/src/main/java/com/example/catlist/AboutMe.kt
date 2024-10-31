package com.example.catlist

import android.os.Bundle
import android.net.Uri
import android.content.Intent
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class AboutMe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)
        supportActionBar?.hide()

        val backButton = findViewById<ImageView>(R.id.back_button)
        backButton.setOnClickListener {
            finish()
        }

        val instagramBtn = findViewById<ImageView>(R.id.my_instagram)
        instagramBtn.setOnClickListener {
            openSocialMedia("https://www.instagram.com/cfchristian_f/")
        }

        val facebookBtn = findViewById<ImageView>(R.id.my_facebook)
        facebookBtn.setOnClickListener {
            openSocialMedia("https://www.facebook.com/ZeesCF/")
        }

        val linkedinBtn = findViewById<ImageView>(R.id.my_linkedin)
        linkedinBtn.setOnClickListener {
            openSocialMedia("https://www.linkedin.com/in/cf-christian-b39a702bb/")
        }
    }

    private fun openSocialMedia(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}