package com.iclickipay.iclickipayapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.iclickipay.iclickipayapplication.R
import com.iclickipay.iclickipayapplication.ui.components.ButtonComponent
import com.iclickipay.iclickipayapplication.ui.navigation.Navigation


@Composable
fun LoginScreen(
    navController: NavController
) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colorStops = arrayOf(
                            0.0f to Color(0xFF017DFF), // Start color
                            0.9f to Color(0xFF1C19A6)  // End color at 50%
                        )
                    )
                ),
        ) {
            Row(
                modifier = Modifier
                    .padding(20.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier
                        .clickable {
                            navController.popBackStack()
                        }
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(120.dp)
                )
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(color = Color.White)
                        )
                        {
                            append("iclick")
                        }
                        withStyle(
                            style = SpanStyle(color = colorResource(R.color.orange))
                        )
                        {
                            append("ipay")
                        }
                    },
                    fontSize = 35.sp
                )
                Text(
                    text = "Password recovery",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(vertical = 20.dp)
                )
                Text(
                    text = "Enter your email",
                    color = Color.White,
                    fontSize = 20.sp
                )
                TextField(
                    value = email.value,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    onValueChange = {
                        email.value = it
                    },
                    label = { Text(text = "Email") },
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Enter your password",
                    color = Color.White,
                    fontSize = 20.sp
                )
                TextField(
                    value = password.value,
                    onValueChange = {
                        password.value = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    label = { Text(text = "Password") },
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                )
                ButtonComponent(
                    onclick = {
                        authenticateUser(
                            navController = navController,
                            email = email.value,
                            password = password.value,
                            routeOnAuthenticated = Navigation.HOME.name,
                            routeOnUnauthenticated = Navigation.SIGNUP.name
                        )
                    },
                    text = "Send"
                )
                Text(
                    text = "No account? Create one!",
                    color = colorResource(R.color.orange),
                    fontSize = 17.sp,
                    modifier = Modifier.clickable { navController.navigate(Navigation.SIGNUP.name) })
            }
        }
    }
}

fun authenticateUser(
    navController: NavController,
    email: String,
    password: String,
    routeOnAuthenticated: String,
    routeOnUnauthenticated: String
) {
    // Authenticate user
    val auth = FirebaseAuth.getInstance()

    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                navController.navigate(routeOnAuthenticated) {
                    popUpTo("login") { inclusive = true }
                }
            } else {
                navController.navigate(routeOnUnauthenticated) {
                    popUpTo("login") { inclusive = true }
                }            }
        }

}