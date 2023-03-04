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
import com.example.yugioh25tcgcardsbanned.databinding.ActivityCardDetailBinding

class CardDetailActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityCardDetailBinding

    companion object{
        val DETAIL_CARD = "detail_card"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCardDetailBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val receivedData: Card? = intent.getParcelableExtra<Card>(DETAIL_CARD) as Card

        Log.d("Detail Card", "onCreate: ${receivedData?.name}")
        receivedData?.let {
            viewBinding.detailCardName.text = it.name
            viewBinding.detailCardType.text = it.type
            viewBinding.detailCardDesc.text = it.desc

            Glide.with(this)
                .load(it.imageUri) // URL Gambar
                .into(viewBinding.detailCardImage)

            viewBinding.actionShare.setOnClickListener { onclickShare(receivedData) }
        }
    }

    private fun onclickShare(data: Card){
        val intent = Intent(Intent.ACTION_SEND).apply {
            putExtra(Intent.EXTRA_SUBJECT, "Check this card!")
            putExtra(Intent.EXTRA_TEXT, "${data.name}, type card: ${data.type}.\n ${data.desc}")
            type = "image/*"
        }
        startActivity(Intent.createChooser(intent, "Share this card"))
    }
}