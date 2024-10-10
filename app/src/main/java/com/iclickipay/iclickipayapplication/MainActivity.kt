package com.iclickipay.iclickipayapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.iclickipay.iclickipayapplication.ui.navigation.Navigation
import com.iclickipay.iclickipayapplication.ui.theme.IClickIPayApplicationTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        enableEdgeToEdge()
        setContent {
            IClickIPayApplicationTheme {
                val navController = rememberNavController()
                App(auth, navController)
            }
        }
    }
}

@Composable
fun App(auth: FirebaseAuth, navController: NavHostController) {
    val startDestination = if (auth.currentUser == null) {
        Navigation.LOGIN.name
    } else {
        Navigation.MAIN.name
    }

    LaunchedEffect(startDestination) {
        navController.navigate(startDestination) {
            popUpTo(0) { inclusive = true }
        }
    }

    Navigation(navController)
}
