package com.example.praktikumremotedatabase.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikumremotedatabase.ui.View.DestinasiEntry
import com.example.praktikumremotedatabase.ui.View.DestinasiHome
import com.example.praktikumremotedatabase.ui.View.EntryMhsScreen
import com.example.praktikumremotedatabase.ui.View.HomeScreen

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()){
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier,
    ) {
        composable(DestinasiHome.route){
            HomeScreen(
                navigateToltemEntry = {navController.navigate(DestinasiEntry.route)},
                onDetailClick = {

                }
            )
        }
        composable(DestinasiEntry.route){
            EntryMhsScreen(navigateBack = {
                navController.navigate(DestinasiHome.route){
                    popUpTo(DestinasiHome.route){
                        inclusive=true
                    }
                }
            })
        }
    }
}