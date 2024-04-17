package co.nz.syncotia.cardsapp.domain.usecase

import co.nz.syncotia.cardsapp.data.model.Card
import co.nz.syncotia.cardsapp.domain.repository.ICardRepository
import javax.inject.Inject

class GetCardsUseCase @Inject constructor(private val repository: ICardRepository) {

    suspend operator fun invoke(): Result<List<Card>> {
        return repository.getCards()
    }
}