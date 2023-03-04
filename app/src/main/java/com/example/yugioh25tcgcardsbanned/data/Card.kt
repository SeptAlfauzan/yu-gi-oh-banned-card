package com.example.yugioh25tcgcardsbanned.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Card(
    val name: String,
    val desc: String,
    val type: String,
    val imageUri: String
) : Parcelable {
    operator fun component1() = name
    operator fun component2() = desc
    operator fun component3() = type
    operator fun component4() = imageUri

}