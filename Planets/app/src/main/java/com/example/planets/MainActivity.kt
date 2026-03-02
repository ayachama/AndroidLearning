package com.example.planets

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.planets.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false) // Disable the default title

        val planet1 = Planet("Mercury", "1", R.drawable.mercury)
        val planet2 = Planet("Venus", "2", R.drawable.venus)
        val planet3 = Planet("Earth", "3", R.drawable.earth)
        val planet4 = Planet("Mars", "4", R.drawable.mars)

        val planets = listOf(planet1, planet2, planet3, planet4)

        val listView = binding.planetlist
        val adapter = MyCustomAdapter(this, planets)
        listView.adapter = adapter


        val btn1 : Button = findViewById(R.id.button1)
        val btn2 : Button = findViewById(R.id.button2)
        loadFragment(FragmentOne())
        btn1.setOnClickListener {
            loadFragment(FragmentOne())
        }
        btn2.setOnClickListener {
            loadFragment(FragmentTwo())
        }
    }

    fun loadFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameloader, fragment)
        fragmentTransaction.commit()
    }

}
