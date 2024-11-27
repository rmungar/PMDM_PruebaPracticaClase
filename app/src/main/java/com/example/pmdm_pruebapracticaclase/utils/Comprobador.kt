package com.example.pmdm_pruebapracticaclase.utils


/**
 * Este object se encarga de comprobar todos los parámetros ingresados por el usuario.
 */

object Comprobador {

    // Conjunto de números en formato String
    private val numbers = listOf("1","2","3","4","5","6","7","8","9","0")

    // Patron del campo email
    private val emailRegex = (
        "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
    )

    // Patrón del campo phone
    private val phoneRegex = (
        "\\+(9[976]\\d|8[987530]\\d|6[987]\\d|5[90]\\d|42\\d|3[875]\\d|\n" +
        "2[98654321]\\d|9[8543210]|8[6421]|6[6543210]|5[87654321]|\n" +
        "4[987654310]|3[9643210]|2[70]|7|1)\\d{1,14}\$"
    )

    /**
     * Función encargada de comprobar el nombre.
     */
    fun comprobarNombre(name: String): Boolean{

        if (name == "" || name.length < 3){
            return false
        }
        for (letra in name){
            if (numbers.contains(letra.toString())){
                return false
            }
        }
        return true
    }

    /**
     * Función encargada de comprobar si la direccion está vacía.
     */
    fun comprobarDireccion(address: String): Boolean{

        if (address == ""){
            return false
        }
        return true
    }

    /**
     * Función encargada de comprobar el DNI aplicando el formato que se ha declarado antes.
     */
    fun comprobarDNI(dni: String): Boolean{
        try{
            // Separo el dni usando el metodo .split() y elimino los caracteres que sean ""
            val dniFormateado = mutableListOf<String>()
            for (i in dni.split("")){
                if (i != "") dniFormateado.add(i)
            }
            // Compruebo el tamaño de la lista anterior y cada uno de sus elementos
            if (dniFormateado.size < 9 || dniFormateado.size > 9) {
                for (caracter in dniFormateado) {
                    if (caracter != dniFormateado[dniFormateado.size - 1]) {
                        if (!numbers.contains(caracter)) {
                            return false
                        }
                    } else {
                        if (numbers.contains(caracter)) return false
                    }
                }
            }
            return true
        }
        catch (e: Exception){
            return false
        }
    }

    // Compruebo si el formato es válido usando el regex del email
    fun comprobarEmail(email: String): Boolean{
        if (email.matches(emailRegex.toRegex())) return true
        return false
    }

    // Compruebo si el formato es válido usando el regex del telefono
    fun comprobarTelefono(phone: String): Boolean{
        if (phone.matches(phoneRegex.toRegex())) return true
        return false
    }




}