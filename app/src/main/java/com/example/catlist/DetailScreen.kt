package com.example.catlist

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)

        supportActionBar?.hide()

        val cat = intent.getParcelableExtra<Cat>("cat_data")
        val backBtn = findViewById<ImageView>(R.id.back_btn)
        backBtn.setOnClickListener {
            finish()
        }


        if (cat != null){
            findViewById<ImageView>(R.id.cat_photo).setImageResource(cat.photo)
            findViewById<TextView>(R.id.cat_breed).text = "Kucing ${cat.breed}"
            findViewById<TextView>(R.id.cat_description).text = cat.description
            findViewById<TextView>(R.id.cat_personality_desc).text = cat.personality
            findViewById<TextView>(R.id.cat_care_desc).text = cat.care

            val shareBtn = findViewById<ImageView>(R.id.action_share)
            shareBtn.setOnClickListener {
                val mBitmap = (findViewById<ImageView>(R.id.cat_photo).drawable as BitmapDrawable).bitmap
                val path = MediaStore.Images.Media.insertImage(contentResolver, mBitmap, "Cat Photo", null)
                val uri = Uri.parse(path)

                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "image/*"
                    putExtra(Intent.EXTRA_TEXT, "Ini merupakan jenis kucing ${cat.breed}")
                    putExtra(Intent.EXTRA_STREAM, uri)
                }
                startActivity(Intent.createChooser(shareIntent, "Share Image"))
            }
        }
    }
}