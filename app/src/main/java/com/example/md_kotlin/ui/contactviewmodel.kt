package com.example.md_kotlin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.md_kotlin.data.NODE_CONTACTS
import com.example.md_kotlin.data.contact
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase

class contactviewmodel: ViewModel() {
    private val dbcontacts = FirebaseDatabase.getInstance().getReference(NODE_CONTACTS)

    private val _result = MutableLiveData<Exception?>()
    val result: LiveData<Exception?> get() = _result

    private val _contact = MutableLiveData<contact>()
    val contact : LiveData<contact> get() = _contact

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

    private val childEventListener = object : ChildEventListener {
        override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
            val sscontact = snapshot.getValue(contact::class.java)
            contact?.id = snapshot.key
            _contact.value = contact!!

        }

        override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
            TODO("Not yet implemented")
        }

        override fun onChildRemoved(snapshot: DataSnapshot) {
            TODO("Not yet implemented")
        }

        override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
            TODO("Not yet implemented")
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }
    }
        fun getrealtimeupdate(){
            dbcontacts.addChildEventListener(childEventListener)
        }

        override fun onCleared(){
            super.onCleared()
            dbcontacts.removeEventListener(childEventListener)
        }

    }

