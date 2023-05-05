package com.example.app_clubes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.app_pokemon.R

class DetailActivity : AppCompatActivity() {

    private lateinit var textViewName: TextView
    private lateinit var  ImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textViewName = findViewById(R.id.textViewEquipo)
        ImageView = findViewById(R.id.imageView)

        val bundle = intent.extras
        val nombre = bundle?.getString("name","")
        val url = bundle?.getString("url") ?:""

        textViewName.text = nombre
        Glide.with(applicationContext)
            .load(url)
            .into(ImageView)



    }
}