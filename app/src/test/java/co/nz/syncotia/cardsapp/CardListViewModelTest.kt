package co.nz.syncotia.cardsapp

import co.nz.syncotia.cardsapp.domain.usecase.GetCardsUseCase
import co.nz.syncotia.cardsapp.ui.screen.CardListViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test
import org.junit.Before
import org.junit.Rule

class CardListViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    private lateinit var cardListViewModel: CardListViewModel

    @Before
    fun injectHiltRule() {
        cardListViewModel = CardListViewModel(GetCardsUseCase(CardRepositoryMock()))
    }

    @Test
    fun cardsListViewModel_loadCards_success() =
        runTest {
            assertFalse(cardListViewModel.state.value.error)
            assertEquals(cardListViewModel.state.value.cards.count(), 4)
        }
}