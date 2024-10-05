package hemanth.doctor.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iclickipay.doctor.R
import com.iclickipayapplication.common.ui.components.CustomButton


enum class DoctorNavigation {
    SCREEN1, SCREEN2, PROFILE, APPOINTMENTS, SETTINGS
}
@Composable
fun DoctorScreen(navController: NavHostController? = null) {
    // Create a separate NavController for Doctor navigation
    val doctorNavController = rememberNavController()


    NavHost(
        navController = doctorNavController,
        startDestination = DoctorNavigation.SCREEN1.name
    ) {
        composable(
            DoctorNavigation.SCREEN1.name,
//            add enter and exit animations
//            enterTransition = Ani
            ) {
            DoctorScreen1(doctorNavController)
        }
        composable(DoctorNavigation.SCREEN2.name) {
            DoctorScreen2(doctorNavController)
        }

    }
}


@Preview
@Composable
fun DoctorScreenPreview() {
    DoctorScreen()
}