package com.example.app_pokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.RecyclerViewClubes)
        recyclerView.layoutManager = LinearLayoutManager(this) //Muestra uno debajo de otro


        adapter = Adapter(applicationContext)

        recyclerView.adapter = adapter

        adapter.submitList(getListadoEquipo())




    }

    private fun getListadoEquipo(): MutableList<Equipo>? {
        return mutableListOf(
            Equipo(1,
                "Boca",
                7,
                Pais.BRASIL,
                "https://upload.wikimedia.org/wikipedia/commons/7/7d/BocaJuniors.png"
            ),
            Equipo(2,
                "River",
                6,
                Pais.ARGENTINA,
                "https://upload.wikimedia.org/wikipedia/commons/3/3f/Logo_River_Plate.png"
            ),

        )

    }


}