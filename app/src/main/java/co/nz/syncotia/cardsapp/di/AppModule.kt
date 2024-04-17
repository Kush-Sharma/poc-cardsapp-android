package co.nz.syncotia.cardsapp.di

import co.nz.syncotia.cardsapp.data.network.CardApi
import co.nz.syncotia.cardsapp.data.repository.CardRepository
import co.nz.syncotia.cardsapp.domain.repository.ICardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideCardsRepository(cardApi: CardApi): ICardRepository {
        return CardRepository(cardApi)
    }
}