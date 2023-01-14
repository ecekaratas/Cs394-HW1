package com.example.recyclerviewexinclass.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CommentDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(comment: Comment)

    @Query("SELECT * FROM comment_table ORDER BY uid ASC")
    fun readAllData(): LiveData<List<Comment>>
}