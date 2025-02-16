package com.example.dicoding_fragment_course

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.example.dicoding_fragment_course.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment(), View.OnClickListener {

    private lateinit var binding : FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDetailCategory.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_detail_category){
            val detailCategoryFragment = DetailCategoryFragment()

            val bundle = Bundle()
            bundle.putString(DetailCategoryFragment.EXTRA_NAME, "lifestyle")

            val desc = "Kategori ini akan berisi produk - produk lifestyle"

            detailCategoryFragment.arguments = bundle
            detailCategoryFragment.desc = desc

            val fragmentManager = parentFragmentManager
            fragmentManager.commit{
                addToBackStack(null)
                replace(R.id.frameContainer, detailCategoryFragment, DetailCategoryFragment::class.java.simpleName)
            }
        }
    }


}