package com.example.simplemvvmnews.fragments.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplemvvmnews.adapter.NewsAdapter
import com.example.simplemvvmnews.databinding.FragmentAndroidNewsBinding
import com.example.simplemvvmnews.viewModel.NewsViewModel


class AndroidNewsFragment:Fragment() {
    private lateinit var binding: FragmentAndroidNewsBinding
    private lateinit var mAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding = FragmentAndroidNewsBinding.inflate(layoutInflater)

        val viewModel = ViewModelProvider(this)[NewsViewModel::class.java]

        viewModel.getNews("android")

        viewModel.newsLiveData.observe(viewLifecycleOwner) {
            mAdapter = NewsAdapter(requireContext(), it.articles)
            binding.recyclerView.adapter = mAdapter
            binding.progressBar.visibility = View.GONE
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        return binding.root
    }
}