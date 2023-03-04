package com.example.yugioh25tcgcardsbanned

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.yugioh25tcgcardsbanned.data.Card

class CardDetailActivity : AppCompatActivity() {
    lateinit var cardName: TextView
    lateinit var cardType: TextView
    lateinit var cardDesc: TextView
    lateinit var cardImage: ImageView

    companion object{
        val DETAIL_CARD = "detail_card"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_detail)

        cardName = findViewById(R.id.detail_card_name)
        cardType = findViewById(R.id.detail_card_type)
        cardDesc = findViewById(R.id.detail_card_desc)
        cardImage = findViewById(R.id.detail_card_image)

        val shareBtn = findViewById<Button>(R.id.action_share)


        val receivedData: Card? = intent.getParcelableExtra<Card>(DETAIL_CARD) as Card

        Log.d("Detail Card", "onCreate: $receivedData")
        receivedData?.let {
            cardName.text = it.name
            cardType.text = it.type
            cardDesc.text = it.desc

            Glide.with(this)
                .load(it.imageUri) // URL Gambar
                .into(cardImage)

            shareBtn.setOnClickListener { onclickShare(receivedData) }
        }
    }

    private fun onclickShare(data: Card){
        val intent = Intent(Intent.ACTION_SEND).apply {
            putExtra(Intent.EXTRA_SUBJECT, "Check this card!")
            putExtra(Intent.EXTRA_TEXT, "${data.name}, type card: ${data.type}.\n ${data.desc}")
            type = "text/plain"
        }
        startActivity(Intent.createChooser(intent, "Share view"))
    }
}