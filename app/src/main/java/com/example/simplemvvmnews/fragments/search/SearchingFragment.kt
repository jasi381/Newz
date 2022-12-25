package com.example.simplemvvmnews.fragments.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplemvvmnews.R
import com.example.simplemvvmnews.adapter.NewsAdapter
import com.example.simplemvvmnews.databinding.FragmentSearchListBinding
import com.example.simplemvvmnews.viewModel.NewsViewModel

class SearchingFragment : Fragment() {

    private lateinit var binding :FragmentSearchListBinding
    private val item :SearchingFragmentArgs by navArgs()
    private lateinit var mAdapter: NewsAdapter
    private lateinit var category: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchListBinding.inflate(layoutInflater)

        val viewModel = ViewModelProvider(this)[NewsViewModel::class.java]

        category = item.category

        viewModel.getNews(category)

        viewModel.newsLiveData.observe(viewLifecycleOwner) {
            mAdapter = NewsAdapter(requireContext(), it.articles)
            binding.recyclerView.adapter = mAdapter
            binding.progressBar.visibility = View.GONE
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        //check if result is empty
        viewModel.newsLiveData.observe(viewLifecycleOwner) {
            if (it.articles.isEmpty()) {
                binding.recyclerView.visibility = View.GONE
                binding.progressBar.visibility = View.GONE
                binding.emptyView.visibility = View.VISIBLE
            }
        }

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_searchingFragment2_to_searchFragment)
        }



        return binding.root

    }
}