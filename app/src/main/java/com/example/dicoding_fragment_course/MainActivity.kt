package com.example.dicoding_fragment_course

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.dicoding_fragment_course.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val fragmentManager = supportFragmentManager
        val homeFragment = HomeFragment()
        val fragment = fragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

//        if (fragment !is HomeFragment) {
//            Log.d("My Fragment", "Fragment Name : " + HomeFragment::class.java.simpleName)
//
//            fragmentManager
//                .beginTransaction()
//                .add(R.id.frameContainer, homeFragment, HomeFragment::class.java.simpleName)
//                .commit()
//        }


        if (fragment !is HomeFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name :" + HomeFragment::class.java.simpleName)

            fragmentManager.commit{
                add(R.id.frameContainer, homeFragment, HomeFragment::class.java.simpleName)
            }
        }

    }


}