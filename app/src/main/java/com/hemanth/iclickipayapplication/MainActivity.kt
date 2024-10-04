package com.hemanth.iclickipayapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hemanth.iclickipayapplication.ui.navigation.Navigation
import com.hemanth.iclickipayapplication.ui.theme.IClickIPayApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IClickIPayApplicationTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    Navigation()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IClickIPayApplicationTheme {
        App()
    }
}