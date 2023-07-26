package com.example.miapparcamiento.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.miapparcamiento.R
import com.example.miapparcamiento.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    //El _binding es el objeto que hace referencia a todos los elementos visuales
    //Todavia no existe y lo vamos a crear despues
    private var _binding: FragmentLoginBinding?= null
    //!! hace que no sea nulo
    private val binding get() = _binding!!
    private lateinit var navController: NavController



// Se crea la vista para que android la muestre en pantalla despues
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        navController= findNavController()

        //crea la vista dentro del contenedor que es la actividad y regresa la vista para que android la dibuje por si sola
        _binding= FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding= null
    }

    //La vista ya existe entonces ya puede trabajar dentro de la vista
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.aceptar.setOnClickListener { login() }
        binding.registrarse.setOnClickListener { signup() }

    }

    fun login() {

        var correo= binding.mail.text?.toString()
        if (correo.isNullOrBlank()){
            binding.mail.error= "Correo necesario"
            return
        }

        var contrasenna= binding.contrasenna.text?.toString()
        if (contrasenna.isNullOrBlank()){
            binding.contrasenna.error="Contraseña necesaria"
            return
        }
        //TODO:Enviar correo y contraseña al servidor

        //le dice inicia una actividad, que es la de mainactivity
        requireActivity().startActivity(Intent(requireContext(), MainActivity::class.java))
        //Finish termina la act de login
        requireActivity().finish()

    }

    fun signup() {

        navController.navigate(R.id.action_loginFragment_to_signUpFragment)
    }
}