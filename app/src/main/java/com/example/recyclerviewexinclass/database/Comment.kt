package com.example.recyclerviewexinclass.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comment_table")
data class Comment(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    val firstName: String,
    val lastName: String,


)
