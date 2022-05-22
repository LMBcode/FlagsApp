package com.example.flagsapp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flagsapp.databinding.ActivityModeBinding

class ModeActivity : AppCompatActivity() {
    private lateinit var _binding : ActivityModeBinding
    private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityModeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.guessCByFlag.setOnClickListener {
            val intent = Intent(this,AuthActivity::class.java)
            startActivity(intent)
        }

        binding.guessFByC.setOnClickListener {
            val intent = Intent(this,AuthActivity2::class.java)
            startActivity(intent)
        }

    }
}