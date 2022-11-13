package com.example.md_kotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment.STYLE_NO_TITLE
import com.example.md_kotlin.R
import com.example.md_kotlin.databinding.FragmentContactBinding.inflate

class addcontactdialogFragment : Fragment() {

    private var _binding: addcontactdialogFragment? = null
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = addcontactdialogFragment.inflate(inflater, container, false)
        return binding.root
    }

}