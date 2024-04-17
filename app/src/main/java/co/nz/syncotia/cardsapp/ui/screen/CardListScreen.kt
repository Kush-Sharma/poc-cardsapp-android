package co.nz.syncotia.cardsapp.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import co.nz.syncotia.cardsapp.mapper.toCardEntity
import co.nz.syncotia.cardsapp.ui.util.view.ErrorView
import co.nz.syncotia.cardsapp.ui.util.view.LoadingSpinner
import co.nz.syncotia.cardsapp.ui.util.view.listrow.CardRow

@Composable
fun CardListScreen(
    viewModel: CardListViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    when {
        state.loading -> {
            LoadingSpinner()
        }

        state.error -> {
            ErrorView {
                viewModel.loadCards()
            }
        }

        else -> {
            LazyColumn {
                items(state.cards, key = { it.id }) {
                    CardRow(card = it.toCardEntity(), onClick = {

                    })
                }
            }
        }
    }
}