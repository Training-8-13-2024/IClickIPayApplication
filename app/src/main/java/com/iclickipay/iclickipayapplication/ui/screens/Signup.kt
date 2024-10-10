package com.iclickipay.iclickipayapplication.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.iclickipay.iclickipayapplication.R
import com.iclickipay.iclickipayapplication.ui.components.Form
import com.iclickipay.iclickipayapplication.ui.navigation.Navigation


@Composable
fun SignUpScreen(
    navController: NavController
) {
    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(vertical = 20.dp, horizontal = 10.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = "Back",
                    tint = colorResource(R.color.orange),
                    modifier = Modifier
                        .weight(.08f)
                        .clickable {
                            navController.popBackStack()
                        }
                )
                Text(
                    text = "Complete the form",
                    fontSize = 25.sp,
                    modifier = Modifier
                        .weight(.92f),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(
                modifier = Modifier
                    .padding(vertical = 10.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.signup),
                    contentDescription = "Image",
                    modifier = Modifier
                        .size(300.dp)
                )
            }
            Spacer(
                modifier = Modifier
                    .padding(vertical = 10.dp)
            )
            Form(
                onFormSubmit = {
                    createUser(
                        email = email.value,
                        password = password.value,
                        navController = navController,
                        context = navController.context
                    )
                },
                firstName = firstName.value,
                onFirstNameChange = { firstName.value = it },
                lastName = lastName.value,
                onLastNameChange = { lastName.value = it },
                email = email.value,
                onEmailChange = { email.value = it },
                password = password.value,
                onPasswordChange = { password.value = it }
            )
        }
    }
}

fun createUser(
    email: String,
    password: String,
    navController: NavController,
    context: Context
) {
    val auth = FirebaseAuth.getInstance()

    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                val user = auth.currentUser
                navController.navigate(Navigation.MAIN.name)
            } else {
                // If sign in fails, display a message to the user.
                Toast.makeText(
                    context,
                    "Authentication failed.",
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }
}