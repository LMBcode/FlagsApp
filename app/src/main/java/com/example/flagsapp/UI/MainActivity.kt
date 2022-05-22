package com.example.flagsapp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flagsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _binding : ActivityMainBinding
    private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.animationView.playAnimation()
        binding.animationView.setOnClickListener {
            val intent = Intent(this,ModeActivity::class.java)
            startActivity(intent)
        }
    }
}