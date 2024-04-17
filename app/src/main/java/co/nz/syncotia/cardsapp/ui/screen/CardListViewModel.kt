package co.nz.syncotia.cardsapp.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.nz.syncotia.cardsapp.data.model.Card
import co.nz.syncotia.cardsapp.domain.usecase.GetCardsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardListViewModel @Inject constructor(
    private val getCardsUseCase: GetCardsUseCase
) : ViewModel() {
    val state = MutableStateFlow(CardScreenState())

    init {
        loadCards()
    }

    fun loadCards() {
        state.value = state.value.copy(loading = true)
        viewModelScope.launch {
            getCardsUseCase().onSuccess {
                state.value = state.value.copy(
                    loading = false,
                    error = false,
                    cards = it
                )
            }.onFailure {
                state.value = state.value.copy(
                    loading = false,
                    error = true
                )
            }
        }
    }

    data class CardScreenState(
        val loading: Boolean = true,
        val error: Boolean = false,
        val cards: List<Card> = emptyList()
    )
}