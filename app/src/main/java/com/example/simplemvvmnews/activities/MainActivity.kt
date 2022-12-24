package com.example.simplemvvmnews.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simplemvvmnews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val _binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}