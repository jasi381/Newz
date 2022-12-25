package com.example.simplemvvmnews.activities

import android.os.Bundle
import android.text.Html
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.simplemvvmnews.R
import com.example.simplemvvmnews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val _binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = Html.fromHtml("<font color='#ffffff'>Newz</font>")
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)

        val navController = navHostFragment!!.findNavController()

        val popupMenu = PopupMenu(this,null)
        popupMenu.inflate(R.menu.bottom_nav_menu)

        binding.bottomBar.setupWithNavController(popupMenu.menu,navController)
    }
}