package com.example.dicoding_fragment_course

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import com.example.dicoding_fragment_course.databinding.FragmentHomeBinding
import java.util.logging.Logger
import kotlin.math.log

class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnCategory = binding.btnCategory
        btnCategory.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
//        if (v?.id == R.id.btn_category) {
//            val categoryFragment = CategoryFragment()
//            val fragmentManager = parentFragmentManager
//            fragmentManager.beginTransaction().apply {
//                replace(R.id.frameContainer, categoryFragment, CategoryFragment::class.java.simpleName)
//                addToBackStack(null)
//                commit()
//            }
//        }

        if (v?.id == R.id.btn_category) {
            val categoryFragment = CategoryFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.commit{
                addToBackStack(null)
                replace(R.id.frameContainer, categoryFragment, CategoryFragment::class.java.simpleName)
            }
        }
    }

}