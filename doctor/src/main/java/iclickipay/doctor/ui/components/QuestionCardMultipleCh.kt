package iclickipay.doctor.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.iclickipayapplication.common.ui.components.RadioButtonWithText


@Composable
fun QuestionCardMultipleCh(
    question: String,
    selectedAnswer: String,
    onAnswerSelected: (String) -> Unit
) {
    Card(
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ){
        Column(
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = question,
                style = MaterialTheme.typography.bodyLarge
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                RadioButtonWithText(
                    label = "Yes",
                    selected = selectedAnswer == "Yes",
                    onClick = { onAnswerSelected("Yes") }
                )
                RadioButtonWithText(
                    label = "No",
                    selected = selectedAnswer == "No",
                    onClick = { onAnswerSelected("No") }
                )
                RadioButtonWithText(
                    label = "I don't know",
                    selected = selectedAnswer == "I don't know",
                    onClick = { onAnswerSelected("I don't know") }
                )
            }
        }
    }
}
