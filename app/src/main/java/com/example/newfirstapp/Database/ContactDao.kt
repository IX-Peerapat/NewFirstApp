package com.example.newfirstapp.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ContactDao {
    @Query("SELECT * from Contact_table ORDER BY name ASC")
    fun getAllContact(): LiveData<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(contact: Contact)
}