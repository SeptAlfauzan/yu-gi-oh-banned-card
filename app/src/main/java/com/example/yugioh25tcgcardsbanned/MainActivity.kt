package com.example.yugioh25tcgcardsbanned

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yugioh25tcgcardsbanned.data.Card
import com.example.yugioh25tcgcardsbanned.data.CardRecycleViewAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var rvCards: RecyclerView
//    private lateinit var viewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCards = findViewById(R.id.rv_card)
        rvCards.setHasFixedSize(true)

        initRecyclerView()
    }

    private fun initRecyclerView(){
        val cards = getAllData()
        val gridLayoutManager = LinearLayoutManager(this)
        rvCards.apply {
            layoutManager = gridLayoutManager
            adapter = CardRecycleViewAdapter(cards, onClick = {
                Log.d("Main Acityv", "initRecyclerView: $it")
                openCardDetail(it)
            })
        }
    }

    private fun openCardDetail(data: Card){
        val intent = Intent(this, CardDetailActivity::class.java).apply {
            putExtra(CardDetailActivity.DETAIL_CARD, data)
        }
        startActivity(intent)
    }

    private fun getAllData(): List<Card>{
        val cardNames = resources.getStringArray(R.array.card_name)
        val cardDesc = resources.getStringArray(R.array.card_desc)
        val cardType = resources.getStringArray(R.array.card_type)
        val cardImageUri = resources.getStringArray(R.array.image_uri)

        val cards: MutableList<Card> = mutableListOf<Card>()

        cardNames.mapIndexed { i, cardName ->
            cards.add(
                Card(cardName, cardDesc[i], cardType[i], cardImageUri[i])
            )
        }

        return cards
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}