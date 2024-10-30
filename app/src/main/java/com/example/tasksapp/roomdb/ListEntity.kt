package com.example.tasksapp.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ListEntity(
    @PrimaryKey
    val listName : String
)
