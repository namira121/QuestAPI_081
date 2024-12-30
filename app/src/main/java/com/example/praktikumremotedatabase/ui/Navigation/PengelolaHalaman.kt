package com.example.praktikumremotedatabase.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.praktikumremotedatabase.ui.View.DestinasiDetail
import com.example.praktikumremotedatabase.ui.View.DestinasiEntry
import com.example.praktikumremotedatabase.ui.View.DestinasiHome
import com.example.praktikumremotedatabase.ui.View.DestinasiUpdate
import com.example.praktikumremotedatabase.ui.View.DetailView
import com.example.praktikumremotedatabase.ui.View.EntryMhsScreen
import com.example.praktikumremotedatabase.ui.View.HomeScreen
import com.example.praktikumremotedatabase.ui.View.UpdateView

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
                onDetailClick = {nim ->
                    navController.navigate("${DestinasiDetail.route}/$nim")
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
        composable(DestinasiDetail.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiDetail.NIM){
                    type = NavType.StringType
                }
            )
        ) {
            val nim = it.arguments?.getString(DestinasiDetail.NIM)
            nim?.let {
                DetailView(
                    NavigateBack = {
                        navController.navigate(DestinasiHome.route) {
                            popUpTo(DestinasiHome.route) {
                                inclusive = true
                            }
                        }
                    },
                    onEditClick =  {},
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
        composable(
            DestinasiUpdate.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiUpdate.NIM) {
                    type = NavType.StringType
                }
            )
        ) {
            val nim = it.arguments?.getString(DestinasiUpdate.NIM)
            nim?.let { nim ->
                UpdateView(
                    navigateBack = {
                        navController.popBackStack()
                    },
                    onNavigateUp =  {
                        navController.navigate(DestinasiHome.route) },
                    nim = nim
                )
            }
        }
    }
}