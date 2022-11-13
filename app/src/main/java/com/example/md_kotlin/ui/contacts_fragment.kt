package com.example.md_kotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.md_kotlin.R
import com.example.md_kotlin.databinding.FragmentContactBinding


class contacts_fragment : Fragment() {

    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!

    private var adapter = contactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewContacts.adapter = adapter

        binding.addButton.setOnClickListener {
            addcontactdialogFragment().show(childFragmentManager, "")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}