package com.example.md_kotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.md_kotlin.R
import com.example.md_kotlin.data.contact
import com.example.md_kotlin.databinding.FragmentAddcontactdialogBinding

class addcontactdialogFragment : DialogFragment() {

    private var _binding: FragmentAddcontactdialogBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: contactviewmodel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddcontactdialogBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[contactviewmodel::class.java]
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.result.observe(viewLifecycleOwner, Observer{
            val message = if(it == null) {
                getString(R.string.added_contact)
            }else{
                getString(R.string.error, it.message)
            }

            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            dismiss()
        })

        binding.buttonAdd.setOnClickListener{
            val fullname = binding.editTextFullName.text.toString().trim()
            val contact = binding.editTextContact.text.toString().trim()

            if(fullname.isEmpty()){
                binding.editTextFullName.error = "this field is required"
                return@setOnClickListener}

            if(contact.isEmpty()){
                binding.editTextContact.error = "this field is required"
                return@setOnClickListener
            }

            val cont = contact()
            cont.fullname = fullname
            cont.contact = contact

            viewModel.addcontact(cont)

        }

    }

}