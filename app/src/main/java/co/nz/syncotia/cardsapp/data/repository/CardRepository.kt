package co.nz.syncotia.cardsapp.data.repository

import co.nz.syncotia.cardsapp.data.model.Card
import co.nz.syncotia.cardsapp.data.network.CardApi
import co.nz.syncotia.cardsapp.domain.repository.ICardRepository
import javax.inject.Inject

class CardRepository @Inject constructor(
    private val cardApi: CardApi,
): ICardRepository {
    override suspend fun getCards(): Result<List<Card>> = runCatching{
        return@runCatching cardApi.gerCards()
    }
}