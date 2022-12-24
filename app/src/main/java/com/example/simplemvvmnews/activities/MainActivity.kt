package com.example.simplemvvmnews.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplemvvmnews.adapter.NewsAdapter
import com.example.simplemvvmnews.databinding.ActivityMainBinding
import com.example.simplemvvmnews.viewModel.NewsViewModel

class MainActivity : AppCompatActivity() {

    private val _binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val binding get() = _binding
    private lateinit var mAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        var viewModel = ViewModelProvider(this)[NewsViewModel::class.java]

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.newsLiveData.observe(this) {
            mAdapter = NewsAdapter(this, it.articles)
            binding.recyclerView.adapter = mAdapter
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }

//
        binding.button.setOnClickListener {
            viewModel.category = binding.editText.text.toString()
            viewModel.getNews()
        }
    }
}