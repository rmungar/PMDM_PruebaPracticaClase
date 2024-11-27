package com.example.pmdm_pruebapracticaclase.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pmdm_pruebapracticaclase.R
import com.example.pmdm_pruebapracticaclase.navigation.Screens
import com.example.pmdm_pruebapracticaclase.utils.Comprobador


@Composable
fun PrimeraPantalla(innerPaddingValues: PaddingValues, navController: NavController){
    PrimeraPantallaBody(innerPaddingValues, navController)
}


/**
 * Esta función, se encarga de mostrar el cuerpo de la primera pantalla, asi como encargarse de hacer las llamadas pertinentes
 * a otras funciones en caso de que sean necesarias.
 * Por dentro no es mas que una columna con varios OutlinedTextFields que van a recoger los datos ingresados por el usuario y un Button que nos permitirá cambiar de ventana.
 *
 *
 * @param innerPaddingValues este parámetro es el padding que va a tener la pantalla en si, es decir, va a tener en cuenta los bordes
 * que tendría un teléfono normal y corriente.
 *
 * @param navController este otro parámetro es el encargado de permitir la navegación entre pantallas.
 *
 */

@Composable
fun PrimeraPantallaBody(innerPaddingValues: PaddingValues, navController: NavController){

    var name by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    var dni by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var number by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(innerPaddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Campo que controla el nombre del usuario
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it

            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Gray,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedBorderColor = colorResource(R.color.purple_200),
                unfocusedBorderColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
                focusedLabelColor = colorResource(R.color.purple_200)
            ),
            label = { Text(text = "Name") }
        )
        // Campo que controla la direccion del usuario
        OutlinedTextField(
            value = address,
            onValueChange = {
                address = it

            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Gray,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedBorderColor = colorResource(R.color.purple_200),
                unfocusedBorderColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
                focusedLabelColor = colorResource(R.color.purple_200)
            ),
            label = { Text(text = "Address") }
        )
        // Campo que controla el DNI del usuario
        OutlinedTextField(
            value = dni,
            onValueChange = {
                dni = it

            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Gray,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedBorderColor = colorResource(R.color.purple_200),
                unfocusedBorderColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
                focusedLabelColor = colorResource(R.color.purple_200)
            ),
            label = { Text(text = "DNI") }
        )
        // Campo que controla el email del usuario
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it

            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Gray,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedBorderColor = colorResource(R.color.purple_200),
                unfocusedBorderColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
                focusedLabelColor = colorResource(R.color.purple_200)
            ),
            label = { Text(text = "Email") }
        )
        // Campo que controla el telefono del usuario
        OutlinedTextField(
            value = number,
            onValueChange = {
                number = it

            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Gray,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedBorderColor = colorResource(R.color.purple_200),
                unfocusedBorderColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
                focusedLabelColor = colorResource(R.color.purple_200)
            ),
            label = { Text(text = "Telephone Number") }
        )
        // Campo que controla el cambio de pantallas
        OutlinedButton (
            shape = RoundedCornerShape(3.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = colorResource(R.color.purple_200),
                contentColor = Color.White,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.Gray,
            ),
            enabled = true,
            border = BorderStroke(2.dp, colorResource(R.color.purple_200)),
            onClick = {

                if (comprobarDatos(name, address, dni, email, number)){
                    navController.navigate(Screens.SegundaPantalla.ruta + "/$name/$address/$dni/$email/$number")
                }

            },
            contentPadding = PaddingValues(9.dp),
            modifier = Modifier
                .padding(start = 5.dp, top = 30.dp)
                .wrapContentWidth()
            ,
        ) {
            Text(text = "Register", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        }

    }
}


/**
 * Esta función, no @Composable se encarga de comprobar todos los datos que ha ingresado el usuario.
 */
private fun comprobarDatos(name: String, address: String, dni:String, email: String, number:String): Boolean {

    var valido = false

    if (Comprobador.comprobarNombre(name) &&
        Comprobador.comprobarDireccion(address) &&
        Comprobador.comprobarDNI(dni) &&
        Comprobador.comprobarEmail(email) &&
        Comprobador.comprobarTelefono(number)
        ) valido = true


    return valido

}


