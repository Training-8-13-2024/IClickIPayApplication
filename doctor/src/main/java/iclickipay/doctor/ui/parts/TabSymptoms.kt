package iclickipay.doctor.ui.parts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TabSymptoms() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .background(color = Color.White),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {


        Column(
            modifier = Modifier
                .padding(25.dp)
                .background(color = Color.White)
        ) {
            Text(text = "Alarming symptoms")
            Spacer(modifier = Modifier.padding(10.dp))
            Row(
                modifier = Modifier
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.Red,
                            shape = RoundedCornerShape(50),
                        )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Force injury")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Row(
                modifier = Modifier
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.Red,
                            shape = RoundedCornerShape(50),
                            )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Severe pain after injury")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Row(
                modifier = Modifier
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.Red,
                            shape = RoundedCornerShape(50),
                        )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Breathing problem after an injury")
            }
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
@Preview
fun TabSymptomsPreview() {
    TabSymptoms()
}