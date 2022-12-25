package com.example.simplemvvmnews.fragments.search

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.simplemvvmnews.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var category:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater)

        setUpList()

       binding.go.setOnClickListener {
              validateEditText()
       }
        binding.CategoryList.setOnItemClickListener { _, _, position, _ ->
            setCategory(position)
        }
        return binding.root
    }

    private fun validateEditText() {
        if(binding.searchEditText.text.toString().trim().isEmpty()){
            binding.searchEditText.error = "Please enter a search query"
        }
        else{
           hideKeybord()
            binding.searchEditText.error = null
            category = binding.searchEditText.text.toString()

            val action = SearchFragmentDirections.actionSearchFragmentToSearchingFragment2(category)
            findNavController().navigate(action)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setCategory(position: Int) {
        when(position){
            0 -> {
                binding.searchEditText.setText("Top Headlines")
            }
            1 -> {
                binding.searchEditText.setText("Android")
            }
            2 -> {
                binding.searchEditText.setText("Animals")
            }
            3 -> {
                binding.searchEditText.setText("Anime")
            }
            4 -> {
                binding.searchEditText.setText("Bitcoin")
            }
            5 -> {
                binding.searchEditText.setText("Bollywood")
            }
            6 -> {
                binding.searchEditText.setText("Cars")
            }
            7 -> {
                binding.searchEditText.setText("Health")
            }
            8 -> {
                binding.searchEditText.setText("HollyWood")
            }
            9 -> {
                binding.searchEditText.setText("Sports")
            }
            10 -> {
                binding.searchEditText.setText("Technology")
            }
            11 -> {
                binding.searchEditText.setText("Esports")
            }
            12 -> {
                binding.searchEditText.setText("Gaming")
            }
            13 -> {
                binding.searchEditText.setText("General")
            }
            14 -> {
                binding.searchEditText.setText("Music")
            }
            15 -> {
                binding.searchEditText.setText("Science")
            }
            16 -> {
                binding.searchEditText.setText("Space")
            }
        }

    }

    private fun hideKeybord() {
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }

    private fun setUpList() {
        val list = arrayOf(
            "Top Headline",
            "Android",
            "Animals",
            "Anime",
            "Bitcoin",
            "Bollywood",
            "Cars",
            "Health",
            "HollyWood",
            "Sports",
            "Technology",
            "Esports",
            "Gaming",
            "General",
            "Music",
            "Science",
            "Space"
        )
        val adapter : ArrayAdapter<String> = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1, list)
        binding.CategoryList.adapter = adapter
    }

}