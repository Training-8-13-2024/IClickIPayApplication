package com.iclickipayapplication.ui.screen.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iclickipay.mechanic.R
import com.iclickipayapplication.common.constants.ORANGE
import com.iclickipayapplication.ui.screen.data.models.Mechanic

@Composable
fun MechanicListComponent(
    listOfMechanics: List<Mechanic>,
    onMechanicClick: (Mechanic) -> Unit = {}
) {
    val orange = colorResource(ORANGE)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
    ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Text(
                        text = "Mechanics"
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    Text(
                        text = listOfMechanics.size.toString(),
                        color = Color.Gray
                    )
                }
                Icon(
                    painter = painterResource(R.drawable.filtericonmechanic),
                    contentDescription = "Filter",
                    tint = orange
                )
            }
            Spacer(
                modifier = Modifier.padding(vertical = 10.dp)
            )
            listOfMechanics.forEach { mechanic ->
                MechanicCardComponent(
                    mechanic = mechanic,
                    onMechanicClick = {
                        onMechanicClick(mechanic)
                    },
                )
            }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MechanicCardComponent(
    mechanic: Mechanic,
    onMechanicClick: () -> Unit = {}
) {
    val liked = remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()
            .clickable {
                onMechanicClick()
            }
            .height(350.dp),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.Black
        )
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(mechanic.mechanicPic),
                contentDescription = "Mechanic Pic",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                AnimatedContent(
                    targetState = liked.value,
                    transitionSpec = {
                        fadeIn(animationSpec = tween (300)) with fadeOut(animationSpec = tween(300))
                    }
                ) { targetState ->
                    val iconResource = if (targetState) R.drawable.heart_filled else R.drawable.heart
                    Image(
                        painter = painterResource(iconResource),
                        contentDescription = "Favorite",
                        modifier = Modifier
                            .size(24.dp) // Adjust size as needed
                            .clickable {
                                liked.value = !liked.value
                            }
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 17.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = mechanic.name)
                    Text(
                        text = mechanic.location.split(",")[1],
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
                Column {
                    mechanic.specialization.forEach { spec ->
                        Text(text = spec, fontSize = 12.sp, color = Color.Gray)
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.rating),
                        contentDescription = "Rating",
                        tint = colorResource(ORANGE)
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    Text(text = mechanic.rating)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.distance),
                        contentDescription = "Location",
                        tint = colorResource(ORANGE)
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    Text(text = mechanic.distance)
                }
                Text(text = "$${mechanic.rate}/h")
            }

        }
    }
}