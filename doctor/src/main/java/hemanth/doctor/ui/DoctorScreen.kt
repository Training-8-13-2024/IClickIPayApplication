package hemanth.doctor.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.iclickipayapplication.common.ui.components.CustomButton

@Composable
fun DoctorScreen(navController: NavHostController) {

    Column (modifier = Modifier.fillMaxSize()) {
        Text(text = "Welcome to Doctor Feature")
        CustomButton(
            text = "Go to Patient",
            onClick = {
            }
        )
    }
}