package com.example.newfirstapp.Database

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface ContactDao {
    @Insert
    fun insert(night: Contact)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun get(contact: Contact)

    @Query("SELECT * FROM contact_table ORDER BY name ASC")
    fun getAllContact(): LiveData<List<Contact>>
}