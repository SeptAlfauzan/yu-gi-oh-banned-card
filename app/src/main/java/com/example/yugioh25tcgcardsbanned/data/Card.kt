package com.example.yugioh25tcgcardsbanned.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Card(
    val name: String,
    val desc: String,
    val type: String,
    val imageUri: String
) : Parcelable