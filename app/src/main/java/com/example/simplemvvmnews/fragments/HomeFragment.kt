package com.example.simplemvvmnews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.simplemvvmnews.adapter.HomeViewPager
import com.example.simplemvvmnews.databinding.FragmentHomeBinding
import com.example.simplemvvmnews.fragments.categories.*
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment :Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryFragment = arrayListOf(
            TopHeadlinesFragment(),
            AndroidNewsFragment(),
            AnimalsNewsFragment(),
            AnimeNewsFragment(),
            BitcoinNewsFragment(),
            BollywoodNewsFragment(),
            CarsNewsFragment(),
            HealthNewsFragment(),
            HollyWoodNewsFragment(),
            SportsNewsFragment(),
            TechnolgyNewsFragment()
        )

        val viewPager2Adapter = HomeViewPager(categoryFragment,childFragmentManager,lifecycle)

        binding.viewPagerHome.adapter = viewPager2Adapter
        TabLayoutMediator(binding.tabLayout,binding.viewPagerHome){tab,position->
            when(position){
                0 -> {
                    tab.text = "Top Headlines"
                }
                1 -> {
                    tab.text = "Android"
                }
                2 -> {
                    tab.text = "Animals"
                }
                3 -> {
                    tab.text = "Anime"
                }
                4 -> {
                    tab.text = "Bitcoin"
                }
                5 -> {
                    tab.text = "Bollywood"
                }
                6 -> {
                    tab.text = "Cars"
                }
                7 -> {
                    tab.text = "Health"
                }
                8 -> {
                    tab.text = "HollyWood"
                }
                9 -> {
                    tab.text = "Sports"
                }
                10 -> {
                    tab.text = "Technology"
                }
            }
        }.attach()
    }
}