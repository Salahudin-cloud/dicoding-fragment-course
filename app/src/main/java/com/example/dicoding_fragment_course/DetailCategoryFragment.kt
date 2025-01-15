package com.example.dicoding_fragment_course

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.dicoding_fragment_course.databinding.FragmentDetailCategoryBinding


class DetailCategoryFragment : Fragment() {

    private lateinit var binding : FragmentDetailCategoryBinding

    var desc : String? = null

    companion object {
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESC = "extra_desc"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            val descFromBundle = savedInstanceState.getString(EXTRA_DESC)
            desc = descFromBundle
        }

        if (arguments != null) {
            val categoryName = arguments?.getString(EXTRA_NAME)
            binding.labelCategoryName.text = categoryName
            binding.labelCategoryDesc.text = desc
        }

        binding.btnShowDialog.setOnClickListener{
            val optionDialogFragment = OptionDialogFragment()
            val fragmentManager = childFragmentManager
            optionDialogFragment.show(fragmentManager, OptionDialogFragment::class.java.simpleName)
        }

        binding.btnProfile.setOnClickListener{
            startActivity(Intent(
                requireActivity(),
                ProfileActivity::class.java
            ))
        }
    }


    internal var optionDialogListener: OptionDialogFragment.OnOptionDialogListener = object : OptionDialogFragment.OnOptionDialogListener{
        override fun onOptionChosen(text: String) {
            Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
        }
    }

}