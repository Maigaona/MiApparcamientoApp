package com.example.miapparcamiento.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.miapparcamiento.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding= null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registrar.setOnClickListener { registro() }
    }

    fun registro() {

        var nombre = binding.nombre.text?.toString()
        if (nombre.isNullOrBlank()) {
            binding.nombre.error = "Nombre necesario"
            return
        }

        var correo = binding.correo.text?.toString()
        if (correo.isNullOrBlank()) {
            binding.correo.error = "Correo necesario"
            return
        }

        var contrasenna = binding.contrasena.text?.toString()
        if (contrasenna.isNullOrBlank()) {
            binding.contrasena.error = "Contraseña necesaria"
            return
        }

        var vercontrasenna = binding.vercontrasena.text?.toString()
        if (vercontrasenna.isNullOrBlank()) {
            binding.vercontrasena.error = "Verifique su contraseña"
            return
        }

        if (contrasenna!=vercontrasenna){
            binding.vercontrasena.error="La contraseña no coincide"
            return
        }

        registrarse()


        requireActivity().startActivity(Intent(requireContext(), MainActivity::class.java))
        requireActivity().finish()
    }

    fun registrarse() {
        //TODO:Guardar la información del usuario en el servidor
    }
}

