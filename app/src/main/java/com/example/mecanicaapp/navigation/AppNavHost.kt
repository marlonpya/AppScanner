package com.example.mecanicaapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mecanicaapp.modules.detail.DetailProductScreen
import com.example.mecanicaapp.modules.scan.ZXingScannerWithLifecycleScreen
import com.example.mecanicaapp.modules.search.SearchScreen

@Composable
fun AppNavHost(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: String = Navigation.Search.route
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Navigation.Search.route) {
            SearchScreen({
                navController.navigate(Navigation.Scan.route)
            }, {
                navController.navigate(Navigation.Detail.route.replace("{id}", it))
            })
        }
        composable(Navigation.Scan.route) {
            ZXingScannerWithLifecycleScreen({
                navController.navigate(Navigation.Detail.route.replace("{id}", it)) {
                    popUpTo(Navigation.Scan.route) { inclusive = true }
                }
            })
        }
        composable(
            Navigation.Detail.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                }
            )
        ) {
            val id = remember { it.arguments?.getString("id") }
            DetailProductScreen(id ?: "")
        }
    }
}