package com.example.newfirstapp.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_table")
data class Contact(

    @PrimaryKey(autoGenerate = true)
    val name: String

)