package co.nz.syncotia.cardsapp.ui.util.view.listrow

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.nz.syncotia.cardsapp.R
import co.nz.syncotia.cardsapp.data.model.CardEntity
import co.nz.syncotia.cardsapp.ui.theme.CardAppTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun CardRow(card: CardEntity, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val painter = painterResource(id = R.drawable.creditcardicon)

            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(80.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = maskCardNumber(card.cardNumber),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "EXP: ${formatDate(card.cardExpiryDate)}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                    )

                    Spacer(modifier = Modifier.width(48.dp))

                    Text(
                        text = card.cardType,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}

private fun maskCardNumber(number: String): String {
    val slices = number.split("-")
    if (slices.size > 3) {
        return "**** **** **** ${slices[3]}"
    }
    return number
}

private fun formatDate(date: String): String {
    var pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val localDate = LocalDate.parse(date, pattern)

    pattern = DateTimeFormatter.ofPattern("MM/yy")
    return localDate.format(pattern)
}

@Preview(showBackground = true)
@Composable
private fun CardRowPreview() {
    CardAppTheme {
        Surface {
            CardRow(
                card = CardEntity(
                    id = 8394,
                    uid = "78d4ddb4-13d9-40c3-9324-478e8228cce9",
                    cardExpiryDate = "2029-04-09",
                    cardNumber = "1221-2211-1122-2112",
                    cardType = "mastercard"
                ),
                onClick = {},
            )
        }
    }
}