package com.example.pmdm_pruebapracticaclase.navigation

sealed class Screens(val ruta: String) {

    object PrimeraPantalla: Screens("PrimeraPantalla")
    object SegundaPantalla: Screens("SegunaPantalla")


}