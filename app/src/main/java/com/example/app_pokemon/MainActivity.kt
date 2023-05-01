package com.example.app_pokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        
        adapter.onItemClickListener = {equipo ->
            val intent = Intent(this,DetailActivity::class.java)
            intent.putExtra("name",equipo.name)
            intent.putExtra("url",equipo.url)
            startActivity(intent)

        }




    }

    private fun getListadoEquipo(): MutableList<Equipo>? {
        return mutableListOf(
            Equipo(1,
                "Boca",
                7,
                Pais.ARGENTINA,
                "https://upload.wikimedia.org/wikipedia/commons/7/7d/BocaJuniors.png"
            ),
            Equipo(2,
                "River",
                6,
                Pais.ARGENTINA,
                "https://upload.wikimedia.org/wikipedia/commons/3/3f/Logo_River_Plate.png"
            ),
            Equipo(3,
                "Palmeiras",
                3,
                Pais.BRASIL,
                "https://logodownload.org/wp-content/uploads/2015/05/palmeiras-logo-0.png"
            ),
            Equipo(4,
                "Manchester United",
                6,
                Pais.INGLATERRA,
                "https://logowik.com/content/uploads/images/862_manchester_united_fc.jpg"
            ),
            Equipo(5,
                "Corinthians",
                4,
                Pais.BRASIL,
                "https://logodownload.org/wp-content/uploads/2016/11/corinthians-logo-0.png"
            ),
            Equipo(6,
                "Liverpool",
                1,
                Pais.INGLATERRA,
                "https://logodownload.org/wp-content/uploads/2017/02/Liverpool-logo-0.png"
            ),
            Equipo(7,
                "Tottenham",
                6,
                Pais.INGLATERRA,
                "https://logodownload.org/wp-content/uploads/2018/11/tottenham-logo-escudo.png"
            ),

        )

    }


}