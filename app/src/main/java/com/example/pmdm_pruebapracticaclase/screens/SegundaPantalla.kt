package com.example.pmdm_pruebapracticaclase.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun SegundaPantalla(navController: NavController, name:String?, address: String?, dni: String?, email: String?, phone:String?){
    SegundaPantallaBody(navController, name, address, dni, email, phone)
}


/**
 * Al igual que la primera pantalla, esta recoge todos los datos del usuario y los muestra por pantalla dentro de un ElevatedCard.
 * @param name
 * @param address
 * @param dni
 * @param email
 * @param phone
 *
 * Todos los parámetros anteriores son los datos ingresados por el usuario que ha recibido la segunda pantalla.
 */
@Composable
fun SegundaPantallaBody(navController: NavController, name:String?, address: String?, dni: String?, email: String?, phone:String?) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(.8f)
                .wrapContentHeight()

        ) {
            Text(text = "WELCOME!!", Modifier.padding(top = 10.dp).align(Alignment.CenterHorizontally), fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = "You have been registered as: $name", Modifier.padding(top = 10.dp, start = 10.dp),fontSize = 18.sp)
            Text(text = "Address: $address",Modifier.padding(top = 10.dp, start = 10.dp),fontSize = 18.sp)
            Text(text = "DNI: $dni", Modifier.padding(top = 10.dp, start = 10.dp),fontSize = 18.sp)
            Text(text = "Email: $email", Modifier.padding(top = 10.dp, start = 10.dp),fontSize = 18.sp)
            Text(text = "Phone Number: $phone", Modifier.padding(top = 10.dp, start = 10.dp),fontSize = 18.sp)
            Text(text = "If there was a mistake in your personal information, please return to the previous screen.",  Modifier.padding(top = 10.dp, start = 10.dp, bottom = 10.dp),fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Button(onClick = { navController.popBackStack() }, modifier = Modifier.align(Alignment.CenterHorizontally)) { Text("Return") }
        }

    }


}