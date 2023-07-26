package com.example.miapparcamiento.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.miapparcamiento.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityLoginBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)

        setSupportActionBar(binding.bar)
    }
}