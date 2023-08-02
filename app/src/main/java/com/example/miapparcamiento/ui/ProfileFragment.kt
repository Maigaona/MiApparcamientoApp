package com.example.miapparcamiento.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.miapparcamiento.R
import com.example.miapparcamiento.databinding.FragmentMyCarBinding
import com.example.miapparcamiento.databinding.FragmentProfileBinding

class ProfileFragment: Fragment() {

    private var _binding: FragmentProfileBinding?= null
    private val binding get() = _binding!!

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        navController= findNavController()

        _binding= FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding= null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.miMembresia.setOnClickListener {
            navController.navigate(R.id.action_profileFragment_to_yourMemberShipFragment)
        }

        binding.miAuto.setOnClickListener {
            navController.navigate(R.id.action_profileFragment_to_myCarFragment)
        }

    }
}