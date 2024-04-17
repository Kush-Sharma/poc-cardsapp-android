package co.nz.syncotia.cardsapp.data.model

import com.google.gson.annotations.SerializedName

data class Card(
    @SerializedName("id")
    val id: Int,
    @SerializedName("uid")
    val uid: String,
    @SerializedName("credit_card_number")
    val cardNumber: String,
    @SerializedName("credit_card_expiry_date")
    val cardExpiryDate: String,
    @SerializedName("credit_card_type")
    val cardType: String
)