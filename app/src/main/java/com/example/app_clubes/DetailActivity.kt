package com.example.app_clubes

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.example.app_pokemon.R

class DetailActivity : AppCompatActivity() {

    private lateinit var textViewName: TextView
    private lateinit var  ImagenView: ImageView
    private lateinit var button : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textViewName = findViewById(R.id.textViewEquipo)
        ImagenView = findViewById(R.id.imageView)
        button = findViewById(R.id.Atras)

        val bundle = intent.extras
        val nombre = bundle?.getString("name","")
        val url = bundle?.getString("url") ?:""

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

        textViewName.text = nombre
        Glide.with(applicationContext)
            .load(url)
            .into(ImagenView)





    }

}