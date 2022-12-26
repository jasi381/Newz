package com.example.simplemvvmnews.fragments.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplemvvmnews.adapter.NewsAdapter
import com.example.simplemvvmnews.databinding.FragmentHealthNewsBinding
import com.example.simplemvvmnews.viewModel.NewsViewModel


class HealthNewsFragment:Fragment() {

    private lateinit var binding: FragmentHealthNewsBinding
    private lateinit var mAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHealthNewsBinding.inflate(layoutInflater)


        val viewModel = ViewModelProvider(this)[NewsViewModel::class.java]

        viewModel.getNews("health",currentDate)

        viewModel.newsLiveData.observe(viewLifecycleOwner) {
            mAdapter = NewsAdapter(requireContext(), it.articles)
            binding.recyclerView.adapter = mAdapter
            binding.progressBar.visibility = View.GONE
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
        return binding.root
    }
}