package com.example.newfirstapp.Database

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class ContactRepository(private val contactDao: ContactDao) {

    val allContact: LiveData<List<Contact>> = contactDao.getAllContact()

    suspend fun insert(contact: Contact) {
        contactDao.insert(contact)
    }
}