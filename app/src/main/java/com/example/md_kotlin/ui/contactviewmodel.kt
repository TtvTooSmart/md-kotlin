package com.example.md_kotlin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.md_kotlin.data.NODE_CONTACTS
import com.example.md_kotlin.data.contact
import com.google.firebase.database.FirebaseDatabase

class contactviewmodel: ViewModel() {
    private val dbcontacts = FirebaseDatabase.getInstance().getReference(NODE_CONTACTS)

    private val _result = MutableLiveData<Exception?>()
    val result: LiveData<Exception?> get() = _result

    fun addcontact(contact: contact){
        contact.id = dbcontacts.push().key

        dbcontacts.child(contact.id!!).setValue(contact).addOnCompleteListener{
            if(it.isSuccessful) {
                _result.value = null
            }else{
                    _result.value = it.exception
                }
            }
        }
    }
