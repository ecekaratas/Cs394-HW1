package com.example.recyclerviewexinclass.database

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CommentViewModel(val dataSource: CommentDao,application: Application): AndroidViewModel(application) {

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
class CommentListViewModelFactory(private val dataSource: CommentDao, private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CommentViewModel::class.java)) {
            return CommentViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}