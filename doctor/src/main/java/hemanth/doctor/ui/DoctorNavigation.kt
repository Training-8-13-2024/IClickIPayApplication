package hemanth.doctor.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hemanth.doctor.ui.screens.AgeScreen
import hemanth.doctor.ui.screens.DoctorGenderScreen
import hemanth.doctor.ui.screens.DoctorScreen1
import hemanth.doctor.ui.screens.DoctorScreen2
import hemanth.doctor.ui.screens.QuestionnaireScreen


enum class DoctorNavigation {
    SCREEN1, SCREEN2, PROFILE, QUESTIONNAIRE, SETTINGS, GENDER, AGE
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
            ) {
            DoctorScreen1(doctorNavController)
        }
        composable(DoctorNavigation.SCREEN2.name) {
            DoctorScreen2(doctorNavController)
        }
        composable(
            DoctorNavigation.GENDER.name,
            ) {
            DoctorGenderScreen(doctorNavController)
        }
        composable(
            DoctorNavigation.AGE.name,
            ) {
            AgeScreen(doctorNavController)
        }
        composable(
            DoctorNavigation.QUESTIONNAIRE.name,
            ) {
            QuestionnaireScreen(doctorNavController)
        }

    }
}


@Preview
@Composable
fun DoctorScreenPreview() {
    DoctorScreen()
}