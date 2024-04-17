package co.nz.syncotia.cardsapp

import co.nz.syncotia.cardsapp.data.model.Card
import co.nz.syncotia.cardsapp.domain.repository.ICardRepository
import javax.inject.Inject

class CardRepositoryMock @Inject constructor(
) : ICardRepository {
    override suspend fun getCards(): Result<List<Card>> = runCatching {
        return@runCatching listOf(
            Card(
                id = 8394,
                uid = "78d4ddb4-13d9-40c3-9324-478e8228cce9",
                cardExpiryDate = "2029-04-09",
                cardNumber = "1221-2211-1122-2112",
                cardType = "mastercard"
            ),
            Card(
                id = 4423,
                uid = "78d4ddb4-13d9-40c3-9324-478e8228cce9",
                cardExpiryDate = "2028-04-09",
                cardNumber = "1221-2211-1122-2112",
                cardType = "visa"
            ),
            Card(
                id = 7942,
                uid = "78d4ddb4-13d9-40c3-9324-478e8228cce9",
                cardExpiryDate = "2027-04-09",
                cardNumber = "1221-2211-1122-2112",
                cardType = "maestro"
            ),
            Card(
                id = 2283,
                uid = "78d4ddb4-13d9-40c3-9324-478e8228cce9",
                cardExpiryDate = "2030-04-09",
                cardNumber = "1221-2211-1122-2112",
                cardType = "mastercard"
            )
        )
    }
}