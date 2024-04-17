package co.nz.syncotia.cardsapp.data.model

data class CardEntity(
    val id: Int,
    val uid: String,
    val cardNumber: String,
    val cardExpiryDate: String,
    val cardType: String,
)