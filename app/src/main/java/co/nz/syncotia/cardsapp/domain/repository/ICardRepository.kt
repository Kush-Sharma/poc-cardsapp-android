package co.nz.syncotia.cardsapp.domain.repository

import co.nz.syncotia.cardsapp.data.model.Card

interface ICardRepository {
    suspend fun getCards(): Result<List<Card>>
}