package com.example.yugioh25tcgcardsbanned.utils.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yugioh25tcgcardsbanned.R
import com.example.yugioh25tcgcardsbanned.data.Card
import com.example.yugioh25tcgcardsbanned.databinding.CardItemBinding

class CardRecycleViewAdapter(val cards: List<Card>, val onClick: (Card) -> Unit = {}): RecyclerView.Adapter<CardRecycleViewAdapter.ViewHolder>() {

    class ViewHolder(binding: CardItemBinding): RecyclerView.ViewHolder(binding.root){
        val binding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = cards.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = cards[position]
        var (name, desc, type, imageUri) = card

        holder.binding.cardName.text = cards[position].name
        holder.binding.cardType.text = cards[position].type

        Glide.with(holder.itemView.context)
            .load(cards[position].imageUri) // URL Gambar
            .into(holder.binding.cardImage)

        holder.itemView.setOnClickListener { onClick(cards[position]) }
    }
}