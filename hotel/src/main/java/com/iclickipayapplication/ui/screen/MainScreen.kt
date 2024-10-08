package com.iclickipayapplication.ui.screen

import com.iclickipayapplication.ui.HotelNavigation
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iclickipay.hotel.R
import com.iclickipayapplication.common.ui.components.CustomButton


@Composable
fun HotelMainScreen(
    navController: NavHostController? = null
) {


    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 10.dp),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(45.dp). padding(0.dp)
                        .height(55.dp)
                        .padding(10.dp)
                        .clickable { navController?.popBackStack() },
                    painter = painterResource(id = R.drawable.back_arrow), contentDescription = "Back")
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxWidth().padding(innerPadding))
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.padding(30.dp))
                Image(
                    painter = painterResource(id = R.drawable.icon_client),
                    contentDescription = "Hotel Screen"
                )
                Spacer(modifier = Modifier.padding(30.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Text(
                        text = "Motel",
                        style = androidx.compose.ui.text.TextStyle(fontSize = 40.sp)
                    )
                    Spacer(modifier = Modifier.padding(30.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth().padding(20.dp),
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis lobortis sit amet odio in egestas. Pellen tesque ultricies justo.",
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.padding(30.dp))

                CustomButton(
                    text = "Let's go",
                    onClick = {
                        navController?.navigate(HotelNavigation.SEARCHHOTEL.name)
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.padding(10.dp))
            }
        }
    }
}
