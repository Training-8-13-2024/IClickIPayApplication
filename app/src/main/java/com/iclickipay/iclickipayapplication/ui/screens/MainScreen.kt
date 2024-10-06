package com.iclickipay.iclickipayapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iclickipay.iclickipayapplication.R


@Composable
fun MainScreen(navController: NavHostController? = null) {
    val items = listOf(
        "Bank" to R.drawable.bank, // Use your resource icons
        "Hotel" to R.drawable.hotel,
        "Mechanic" to R.drawable.repair,
        "Doctor" to R.drawable.sante,
        "Tinder" to R.drawable.meet,
        "Learn" to R.drawable.tuteur,
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(
            text = "Welcome to the IClick IPay Application",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFF8721),
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(items.size) { index ->
                GridItem(
                    label = items[index].first,
                    iconRes = items[index].second,
                    onClick = {
                        when (items[index].first) {
                            "Bank" -> navController?.navigate("bank")
                            "Hotel" -> navController?.navigate("hotel")
                            "Mechanic" -> navController?.navigate("mechanic")
                            "Doctor" -> navController?.navigate("doctor")
                            "Tinder" -> navController?.navigate("tinder")
                            "Learn" -> navController?.navigate("learn")

                        }
                    }
                )
            }
        }
    }


}

@Composable
fun GridItem(label: String, iconRes: Int, onClick: () -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .padding(8.dp)
            .size(240.dp)
            .background(Color.Transparent)
            .clickable { onClick() },
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )

    ) {
        Column(
            modifier = Modifier.background(Color.Transparent).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(180.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = label,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                color = Color.Black
            )
        }
    }
}

@Composable
@Preview
fun MainScreenPreview() {
    MainScreen()
}