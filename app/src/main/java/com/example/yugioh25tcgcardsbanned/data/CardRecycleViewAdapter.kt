package com.example.yugioh25tcgcardsbanned.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yugioh25tcgcardsbanned.R

class CardRecycleViewAdapter(val cards: List<Card>, val onClick: (Card) -> Unit = {}): RecyclerView.Adapter<CardRecycleViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val cardName = itemView.findViewById<TextView>(R.id.card_name)
        val cardType = itemView.findViewById<TextView>(R.id.card_type)
        val cardImage = itemView.findViewById<ImageView>(R.id.card_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = cards.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        var (name, desc, type, imageUri) = cards[position]
        holder.cardName.text = cards[position].name
        holder.cardType.text = cards[position].type

        Glide.with(holder.itemView.context)
            .load(cards[position].imageUri) // URL Gambar
            .into(holder.cardImage)

        holder.itemView.setOnClickListener { onClick(cards[position]) }
    }
}