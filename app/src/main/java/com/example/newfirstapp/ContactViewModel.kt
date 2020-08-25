package com.example.newfirstapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.newfirstapp.Database.Contact
import com.example.newfirstapp.Database.ContactDatabase
import com.example.newfirstapp.Database.ContactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application) {

    val allcontacts: LiveData<List<Contact>>
    private val repository: ContactRepository

    init {
        val userDao = ContactDatabase.getDatabase(application,viewModelScope).contactDao()
        repository = ContactRepository(userDao)
        allcontacts = repository.allContact
    }

    fun addUser(contact: Contact){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(contact)
        }
    }
}

