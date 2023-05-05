package com.example.app_pokemon

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter (val context: Context) : ListAdapter<Equipo, Adapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Equipo) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val name : TextView = view.findViewById(R.id.textViewNomClub)
        private val campeonato : TextView = view.findViewById(R.id.textViewTotalCampeonato)
        private val logo: ImageView = view.findViewById(R.id.imageViewEscudo)
        private val imagenPais: ImageView = view.findViewById(R.id.imageViewPais)

        fun bind (equipo: Equipo) {
            name.text = equipo.name.toString()
            campeonato.text = "Campeonato: " + equipo.campeonatos.toString()


            val image = when(equipo.pais) {
                Pais.ARGENTINA-> R.drawable.argentina
                Pais.BRASIL-> R.drawable.brazil
                Pais.INGLATERRA-> R.drawable.inglaterra


            }

            imagenPais.setImageResource(image)


            //LIBRERIA PARA PODER TRAER LAS FOTOS DE INTERNET
            Glide.with(context)
                .load(equipo.url)
                .into(logo)

            view.setOnClickListener {
                onItemClickListener(equipo)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.itemlist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val equipos = getItem(position)
        holder.bind(equipos)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Equipo>() {
        override fun areItemsTheSame(oldItem: Equipo, newItem: Equipo): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Equipo, newItem: Equipo): Boolean {
            return oldItem == newItem
        }
    }
}