package com.example.dicoding_fragment_course

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.dicoding_fragment_course.databinding.FragmentOptionDialogBinding

class OptionDialogFragment : DialogFragment() {

    private var _binding: FragmentOptionDialogBinding? = null
    private val binding get() = _binding!!

    private var  onOptionDialogListener: OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using View Binding
        _binding = FragmentOptionDialogBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnChoose.setOnClickListener{
            val checkedRadioButton = binding.rgOptions.checkedRadioButtonId
            if (checkedRadioButton != -1) {
                var coach : String? = when(checkedRadioButton) {
                    R.id.rb_mou -> binding.rbMou.toString().trim()
                    R.id.rb_lvg -> binding.rbLvg.toString().trim()
                    R.id.rb_moyes -> binding.rbMoyes.toString().trim()
                    else -> null
                }
                onOptionDialogListener?.onOptionChosen(coach.toString())
                dialog?.dismiss()
            }
        }
        binding.btnChoose.setOnClickListener{
            dialog?.cancel()
        }

    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment = parentFragment

        if (fragment is DetailCategoryFragment) {
            this.onOptionDialogListener = fragment.optionDialogListener
        }
    }
    override fun onDetach() {
        super.onDetach()
        this.onOptionDialogListener = null
    }

    interface OnOptionDialogListener {
        fun onOptionChosen(text:String)
    }



}