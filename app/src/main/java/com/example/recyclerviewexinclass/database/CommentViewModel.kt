package com.example.recyclerviewexinclass.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CommentViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Comment>>
    private val repository: CommentRepository

    init {
        val userDao = CommentDatabase.getDatabase(application).commentDao()
        repository = CommentRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(comment: Comment){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(comment)
        }
    }
}