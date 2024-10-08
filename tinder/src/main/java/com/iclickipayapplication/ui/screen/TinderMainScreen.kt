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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
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
fun TinderMainScreen(navController: NavHostController, viewModel: ProductAdapter = hiltViewModel(),) {
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
                        .weight(1f)
                        .padding(10.dp)
                        .clickable { navController.navigate(TinderNavigationData.TUTORIAL.name) },
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Back"
                )
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .weight(1f)
                        .padding(10.dp)
                        .clickable { },
                    painter = painterResource(id = R.drawable.msg),
                    contentDescription = "Back"
                )
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .weight(1f)
                        .padding(10.dp)
                        .clickable { navController.navigate(TinderNavigationData.PROFILE.name) },
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Back"
                )
            }
        }
    ){ innerPadding ->
        val upcomingData = viewModel.upcomingData.value
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
            ) {
                LazyRow(modifier = Modifier.weight(0.8f)){
                    items(upcomingData) {item -> TinderCard(color = cardBackgroundColor, data = item, navController = navController) }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.2f),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    TinderImage(painter = painterResource(id = R.drawable.rereturn), onClick = { cardBackgroundColor = Color(0xFF2196F3) })
                    TinderImage(painter = painterResource(id = R.drawable.cancel), onClick = { cardBackgroundColor = Color(0xFFFF7A1A) })
                    TinderImage(painter = painterResource(id = R.drawable.fire), onClick = { cardBackgroundColor = Color(0xFF6C63FF) })
                    TinderImage(painter = painterResource(id = R.drawable.love), onClick = { cardBackgroundColor = Color(0xFF63E2BC) })
                    TinderImage(painter = painterResource(id = R.drawable.stars), onClick = { cardBackgroundColor = Color(0xFFFFC10E) })
                }

            }
        }
    }
}
