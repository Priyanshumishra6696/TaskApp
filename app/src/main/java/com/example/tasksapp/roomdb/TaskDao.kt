package com.example.tasksapp.roomdb

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface TaskDao {

    @Upsert
    suspend fun addList(listEntity: ListEntity)

    @Upsert
    suspend fun addTask(TaskEntity:TaskEntity)

    @Query("Select * from taskentity where listName=:listName")
    suspend fun getTask(listName:String) : List<TaskEntity>

    @Query("select * from taskentity where taskCheck=0 and listName=:listName ")
    suspend fun getuncompletedtask(listName: String) : List<TaskEntity>

    @Query("select * from taskentity where taskCheck=true and listName=:listName")
    suspend fun getCompletedTask(listName: String) : List<TaskEntity>

    @Query("delete from taskentity where listName=:listName and taskCheck=true")
    suspend fun deleteCompletedTaskOfList(listName: String)

    @Query("select * from listentity")
    suspend fun getlist() : List<ListEntity>

    @Query("delete from listentity where listName=:listName")
    suspend fun deletelist(listName: String)

    @Query("delete from taskentity where listName=:listName")
    suspend fun deletetasksOflist(listName: String)

    @Query("delete from taskentity where id=:id")
    suspend fun deleteTask(id:Int)
}