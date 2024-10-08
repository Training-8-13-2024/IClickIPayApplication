package com.iclickipayapplication.ui.screen

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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.iclickipay.tinder.R
import com.iclickipayapplication.ui.TinderNavigationData
import com.iclickipayapplication.viewmodel.ProductAdapter

@Composable
fun TinderDetailsScreen(navController: NavHostController, viewModel: ProductAdapter = hiltViewModel(), id: Int){
    val upcomingData = viewModel.upcomingData.value
    val data = upcomingData.find { it.id == id } ?: return
    var cardBackgroundColor by remember { mutableStateOf(Color.White) }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .padding(10.dp)
                        .clickable { navController.navigate(TinderNavigationData.MAIN.name) },
                    painter = painterResource(id = com.iclickipayapplication.common.R.drawable.backarrow),
                    contentDescription = "Back"
                )
            }
        }
    ){innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box (modifier = Modifier.weight(0.7f)){
                    TinderCard(data = data, color = cardBackgroundColor, navController = navController)
                }
                Spacer(modifier = Modifier.height(16.dp))
                data.description?.let { Text(text = it) }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.2f),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TinderImage(painter = painterResource(id = R.drawable.cancel), onClick = { cardBackgroundColor = Color(0xFFFF7A1A) })
                    TinderImage(painter = painterResource(id = R.drawable.fire), onClick = { cardBackgroundColor = Color(0xFF6C63FF) })
                    TinderImage(painter = painterResource(id = R.drawable.love), onClick = { cardBackgroundColor = Color(0xFF63E2BC) })
                    TinderImage(painter = painterResource(id = R.drawable.stars), onClick = { cardBackgroundColor = Color(0xFFFFC10E) })
                }
            }
        }
    }

}