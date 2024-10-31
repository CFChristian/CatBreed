package com.example.catlist

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {

    private lateinit var rvCats: RecyclerView
    private val list = ArrayList<Cat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
            setDisplayShowCustomEnabled(true)
            setCustomView(R.layout.custom_action_bar)
        }

        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.light_blue)))
        supportActionBar?.elevation = 0f

        rvCats = findViewById(R.id.rv_catList)
        rvCats.setHasFixedSize(true)

        list.addAll(getListCats())
        showRecyclerList()
    }

    private fun getListCats(): ArrayList<Cat>{
        val dataBreed = resources.getStringArray(R.array.cat_data_breed)
        val dataDescription = resources.getStringArray(R.array.cat_data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.cat_data_photo)
        val dataCare = resources.getStringArray(R.array.cat_data_care)
        val dataPersonality = resources.getStringArray(R.array.cat_data_personality)
        val listCat = ArrayList<Cat>()
        for (i in dataBreed.indices){
            val cat = Cat(
                dataBreed[i],
                dataDescription[i],
                dataPhoto.getResourceId(i, -1),
                dataPersonality[i],
                dataCare[i],
            )
            listCat.add(cat)
        }
        return listCat
    }

    private fun showRecyclerList(){
        rvCats.layoutManager = LinearLayoutManager(this)
        val listCatAdapter = ListCatAdapter(list)
        rvCats.adapter = listCatAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.user -> {
                val moveIntent = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(moveIntent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}