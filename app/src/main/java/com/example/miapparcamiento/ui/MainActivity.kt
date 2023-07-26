package com.example.miapparcamiento.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.miapparcamiento.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //La variable se va a asignar despues, el binding es el objeto que hace referencia a todos los elementos visuales.
    private lateinit var binding: ActivityMainBinding


     //Durante la funcion on created se va a crear la vista que va a mostrar en pantalla.

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)

       //Inflate es para crear los elementos visuales, para mostrarlos en pantalla es setcontentview

       binding= ActivityMainBinding.inflate(layoutInflater, null, false)
       setContentView(binding.root)

       //Es para que android sepa que tiene que usar nuestro toolbar

       setSupportActionBar(binding.bar)

   }
}

