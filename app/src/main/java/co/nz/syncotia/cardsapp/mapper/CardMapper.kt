package co.nz.syncotia.cardsapp.mapper

import co.nz.syncotia.cardsapp.data.model.Card
import co.nz.syncotia.cardsapp.data.model.CardEntity

fun Card.toCardEntity(): CardEntity {
    return CardEntity(
        id = id,
        uid = uid,
        cardNumber = cardNumber,
        cardExpiryDate = cardExpiryDate,
        cardType = cardType,
    )
}

fun CardEntity.toCard(): Card {
    return Card(
        id = id,
        uid = uid,
        cardNumber = cardNumber,
        cardExpiryDate = cardExpiryDate,
        cardType = cardType,
    )
}