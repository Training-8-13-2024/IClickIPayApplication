package com.iclickipayapplication.ui

import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iclickipayapplication.ui.screen.ProfileCompletionScreen
import com.iclickipayapplication.ui.screen.TinderMainScreen
import com.iclickipayapplication.ui.screen.TinderMapScreen
import com.iclickipayapplication.ui.screen.TinderMeetScreen
import com.iclickipayapplication.ui.screen.TinderPhotoScreen
import com.iclickipayapplication.ui.screen.TinderScreen
import com.iclickipayapplication.ui.screen.TinderTutorialScreen

enum class TinderNavigationData {
    HOME, SCREEN2, PROFILE, MAP, TUTORIAL, MAIN, PHOTO
}
@Composable
fun TinderNavigation(navController: NavHostController? = null) {
    val tinderNavController = rememberNavController()


    NavHost(
        navController = tinderNavController,
        startDestination = TinderNavigationData.HOME.name
    ) {
        composable(TinderNavigationData.HOME.name) { TinderScreen(navController = tinderNavController) }
        composable(TinderNavigationData.SCREEN2.name) { TinderMeetScreen(navController = tinderNavController) }
        composable(TinderNavigationData.PHOTO.name) { TinderPhotoScreen(navController = tinderNavController) }
        composable(TinderNavigationData.PROFILE.name) { ProfileCompletionScreen(navController = tinderNavController) }
        composable(TinderNavigationData.MAP.name) { TinderMapScreen(navController = tinderNavController) }
        composable(TinderNavigationData.TUTORIAL.name) { TinderTutorialScreen(navController = tinderNavController) }
        composable(TinderNavigationData.MAIN.name) { TinderMainScreen(navController = tinderNavController) }


    }
}