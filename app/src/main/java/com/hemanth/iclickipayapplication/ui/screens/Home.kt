package com.hemanth.iclickipayapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hemanth.iclickipayapplication.R


@Composable
fun Home(
    navController: NavController
){
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(brush = Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.0f to Color( 0xFF017DFF), // Start color
                        0.9f to Color(0xFF1C19A6)  // End color at 50%
                    )
                )),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(200.dp)
            )
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(color = Color.White))
                    {
                        append("iclick")
                    }
                    withStyle(
                        style = SpanStyle(color = colorResource(R.color.orange)))
                    {
                        append("ipay")
                    }
                },
                fontSize = 55.sp
            )
            Text(text = "Your mobile bank", color = Color.White)
            Spacer(modifier = Modifier
                .height(100.dp)
            )
            Button(
                onClick = {
                    navController.navigate("info")
                },
                colors = ButtonColors(
                    containerColor = colorResource(R.color.orange),
                    contentColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.White
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .width(200.dp)
                    .height(50.dp)
            ){
                Text(text = "Sign up", fontSize = 17.sp)
            }
            Text(text = "Sign in", color = colorResource(R.color.orange), fontSize = 17.sp, modifier = Modifier.clickable { navController.navigate("login") } )
        }
    }
}