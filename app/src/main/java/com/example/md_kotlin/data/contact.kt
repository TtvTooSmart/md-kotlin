package com.example.md_kotlin.data

import com.google.firebase.database.Exclude

data class contact(
    @get:Exclude
    var id: String? = null,
    var fullname: String? = null,
    var contact: String? = null
) {
}