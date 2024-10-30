package com.example.tasksapp.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val taskEntered : String,
    val taskCheck : Boolean = false,
    val listName : String
)
