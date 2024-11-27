package com.example.pmdm_pruebapracticaclase.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pmdm_pruebapracticaclase.screens.PrimeraPantalla
import com.example.pmdm_pruebapracticaclase.screens.SegundaPantalla


/**
 * Esta funcion se encarga de manejar el desplazamiento entre pantallas, pasando por argumento todos los parámetros ingresados por el usuario,
 * mediante el uso de las rutas y los argumentos.
 */

@Composable
fun AppNavigator(innerPaddingValues: PaddingValues){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.PrimeraPantalla.ruta) {

        composable(Screens.PrimeraPantalla.ruta) {
            PrimeraPantalla(innerPaddingValues, navController)
        }

        composable(Screens.SegundaPantalla.ruta + "/{nombre}/{address}/{dni}/{email}/{phone}",
            arguments = listOf(
                navArgument("nombre") { type = NavType.StringType },
                navArgument("address") { type = NavType.StringType },
                navArgument("dni") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType },
                navArgument("phone") { type = NavType.StringType }
            )
        ){

            val nombre = it.arguments?.getString("nombre")
            val address = it.arguments?.getString("address")
            val dni = it.arguments?.getString("dni")
            val email = it.arguments?.getString("email")
            val phone = it.arguments?.getString("phone")


            SegundaPantalla(navController, nombre, address, dni, email, phone)
        }

    }



}