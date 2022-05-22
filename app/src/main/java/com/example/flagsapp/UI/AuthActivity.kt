package com.example.flagsapp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.flagsapp.Model.QuestionsSource
import com.example.flagsapp.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
        private lateinit var _binding : ActivityAuthBinding
        private val binding get() = _binding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            _binding = ActivityAuthBinding.inflate(layoutInflater)
            setContentView(binding.root)
            val start = binding.btnStart
            start.setOnClickListener {
                if(binding.username.text.isEmpty()) {
                    Toast.makeText(this,"Please enter username", Toast.LENGTH_SHORT).show()
                }
                else{
                    val intent = Intent(this,GuessTheFlagActivity::class.java)
                    intent.putExtra(QuestionsSource.Username,binding.username.text.toString())
                    startActivity(intent)
                }
            }
            binding.btnLeaderboard.setOnClickListener {
                val Intent =  Intent(this, LeaderboardActivity::class.java)
                startActivity(Intent)
            }
        }
    }