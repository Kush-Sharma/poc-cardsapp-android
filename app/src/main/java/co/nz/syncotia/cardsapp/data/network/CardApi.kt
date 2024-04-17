package co.nz.syncotia.cardsapp.data.network

import co.nz.syncotia.cardsapp.data.model.Card
import retrofit2.http.GET

interface CardApi {

    companion object {
        const val BASE_URL = "https://random-data-api.com/api/v2/"
    }

    @GET("credit_cards?size=100")
    suspend fun gerCards(): List<Card>
}