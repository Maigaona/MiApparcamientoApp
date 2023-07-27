package com.example.miapparcamiento.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.miapparcamiento.R
import com.example.miapparcamiento.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityLoginBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)

        //Esto le dice a android que nuestro toolbar es la barra de la aplicación
        setSupportActionBar(binding.bar)
        //el navhostfragment es lo que contiene los fragmentos
        //Extraer el navhost de la vista
        val navHostFragment= supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        //Obtenemos el nav controller del navhost, el nav controller tiene la información de navegación
        navController= navHostFragment.navController
        //Creamos una configuración a partir de la gráfica de navegación
        appBarConfiguration= AppBarConfiguration(navController.graph)
        //Le decimos al toolbar que use la gráfica de navegación
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
    //Le da funcionalidad a la flechita del toolbar
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)||super.onSupportNavigateUp()
    }
}