package com.example.md_kotlin.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.md_kotlin.data.contact
import com.example.md_kotlin.databinding.RecycleViewContactBinding

class contactAdapter: RecyclerView.Adapter<contactAdapter.ViewHolder>(){

    var contacts = mutableListOf<contact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RecycleViewContactBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return contacts.size
    }
    inner class ViewHolder(val binding: RecycleViewContactBinding): RecyclerView.ViewHolder(binding.root){

    }
}