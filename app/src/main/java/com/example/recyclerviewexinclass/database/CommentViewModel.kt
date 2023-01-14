package com.example.recyclerviewexinclass.database

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CommentViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Comment>>
    public val repository: CommentRepository

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
