package com.example.sheredpreferences

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class Mensaje : AppCompatActivity() {

    var txtUsuario:TextView?=null
    var txtPass:TextView?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensaje)

        val resulUser = findViewById<TextView>(R.id.txtUsuario)
        val resulPass = findViewById<TextView>(R.id.txtPass)

        // Obtener las preferencias compartidas
        val preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE)

        // Obtener el usuario y contraseña guardados en las preferencias compartidas
        val user: String? = preferences.getString("user", "No existe la información")
        val pass: String? = preferences.getString("pass", "No existe la información")

        // Establecer el texto de los TextView correspondientes con los valores obtenidos de las preferencias compartidas
        resulUser.text = "Bienvenido $user"
        resulPass.text = pass

        val botonsalir:Button=findViewById(R.id.btnSalir)
        botonsalir.setOnClickListener { onClick() }
    }

    private fun onClick() {
        finish()
    }
}
