package com.example.simplemvvmnews.fragments.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.simplemvvmnews.R
import com.example.simplemvvmnews.databinding.FragmentSearchListBinding

class SearchingFragment : Fragment() {

    private lateinit var binding :FragmentSearchListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSearchListBinding.inflate(layoutInflater)

        binding.backButton.setOnClickListener {
            navigateToSearchFragment()
        }

        return binding.root

    }

    private fun navigateToSearchFragment() {
        findNavController().navigate(R.id.action_searchingFragment2_to_searchFragment)
    }

}