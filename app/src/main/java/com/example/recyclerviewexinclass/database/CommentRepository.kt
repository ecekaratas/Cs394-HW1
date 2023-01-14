package com.example.recyclerviewexinclass.database

import androidx.lifecycle.LiveData


class CommentRepository(private val commentDao: CommentDao) {

    val readAllData: LiveData<List<Comment>> = commentDao.readAllData()

    suspend fun addUser(user: Comment){
        commentDao.addUser(user)
    }
}