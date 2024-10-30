package com.example.tasksapp.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity::class,ListEntity::class] , version = 1)
abstract class TaskDatabase : RoomDatabase(){
    abstract fun getTaskDao() : TaskDao
}
