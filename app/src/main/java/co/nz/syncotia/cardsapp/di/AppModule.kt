package co.nz.syncotia.cardsapp.di

import co.nz.syncotia.cardsapp.data.repository.CardRepository
import co.nz.syncotia.cardsapp.domain.repository.ICardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    abstract fun bindCardsRepository(
        cardsRepository: CardRepository
    ): ICardRepository
}