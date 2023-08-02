package com.example.miapparcamiento.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.miapparcamiento.Constantes
import com.example.miapparcamiento.R
import com.example.miapparcamiento.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //La variable se va a asignar despues, el binding es el objeto que hace referencia a todos los elementos visuales.
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController



     //Durante la funcion on created se va a crear la vista que va a mostrar en pantalla.

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)

       //sharedpreferences guarda pares de llave y valor permanentemente
       var sharedPreferences= getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE)

       //Si no tiene un valor para usuario entonces guardamos el valor falso
       if (!sharedPreferences.contains(Constantes.USUARIO)){
           with(sharedPreferences.edit()){
               putBoolean(Constantes.USUARIO, false)
               apply()
           }
       }
       //sacar el valor del usuario de sharedpreferences
        var usuario= sharedPreferences.getBoolean(Constantes.USUARIO, false)
       if (!usuario) {
           startActivity(Intent(this,LoginActivity::class.java))
           finish()
           return
       }

       //Inflate es para crear los elementos visuales, para mostrarlos en pantalla es setcontentview

       binding= ActivityMainBinding.inflate(layoutInflater, null, false)
       setContentView(binding.root)

       //Es para que android sepa que tiene que usar nuestro toolbar

       setSupportActionBar(binding.bar)

       val navHostFragment= supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
       navController= navHostFragment.navController
       appBarConfiguration= AppBarConfiguration(navController.graph)
       setupActionBarWithNavController(navController, appBarConfiguration)

   }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}

