package co.nz.syncotia.cardsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import co.nz.syncotia.cardsapp.ui.screen.CardListScreen
import co.nz.syncotia.cardsapp.ui.theme.CardAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardAppTheme {
                CardListScreen()
            }
        }
    }
}