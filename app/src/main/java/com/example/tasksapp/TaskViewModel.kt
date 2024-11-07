package com.example.tasksapp

import android.view.View
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tasksapp.roomdb.ListEntity
import com.example.tasksapp.roomdb.TaskDao
import com.example.tasksapp.roomdb.TaskEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(private val taskDao: TaskDao): ViewModel() {


    // Live data to hold tabs and tasks
    val tabs = mutableStateListOf<ListEntity>()
    val tasks = mutableStateMapOf<String, List<TaskEntity>>()
    val completedTasksMapper = mutableStateMapOf<String,List<TaskEntity>>()
    var currentListName = mutableStateOf("My Tasks")
    val selected = mutableStateOf(1)
    val showModalBottomSheet = mutableStateOf(false)
    val showCompletedTasks = mutableStateOf(false)
    val uncompletedTasks = mutableStateMapOf<String , List<TaskEntity>>()
    fun getCurrList(): String {
        return currentListName.value
    }
    fun updateCurrentListName(listName: String){
        currentListName.value = listName
    }


    init {
        viewModelScope.launch {
            tabs.add(ListEntity("Starred"))
            tabs.add(ListEntity("My Tasks"))
            tabs.addAll(taskDao.getlist())
            for (tab in tabs) {
                tasks[tab.listName] = taskDao.getTask(tab.listName)
                completedTasksMapper[tab.listName] = taskDao.getCompletedTask(listName = tab.listName)
                uncompletedTasks[tab.listName] = taskDao.getuncompletedtask(tab.listName)
            }
        }
    }
    fun addTask(taskEntered :String,listName: String){
        viewModelScope.launch {
            taskDao.addTask(TaskEntity(taskEntered = taskEntered, listName = listName))
            tasks[listName] = taskDao.getTask(listName)
            uncompletedTasks[listName] = taskDao.getuncompletedtask(listName)
        }
    }
    fun deletelist(listName: String){
        viewModelScope.launch {
            taskDao.deletelist(listName)
            taskDao.deletetasksOflist(listName)

            tabs.remove(ListEntity(listName))
            tasks.remove(listName)
        }
    }
    fun addList(listName : String){
        viewModelScope.launch {
            taskDao.addList(listEntity = ListEntity(listName = listName))
            tabs.add(ListEntity(listName = listName))
        }
    }

    fun updateCompletedTask(completedTask : String , listName : String){
        viewModelScope.launch {
            taskDao.addTask(TaskEntity(taskEntered = completedTask, listName = listName, taskCheck = true))
            completedTasksMapper[listName] = taskDao.getCompletedTask(listName = listName)
            uncompletedTasks[listName] = taskDao.getuncompletedtask(listName)
        }
    }

    fun deleteCompletedTaskOfList(listName: String){
        viewModelScope.launch {
            taskDao.deleteCompletedTaskOfList(listName)
            completedTasksMapper[listName] = taskDao.getCompletedTask(listName)
            tasks[listName] = taskDao.getTask(listName)
        }
    }

    fun deleteTask(id : Int,listName: String){
        viewModelScope.launch(Dispatchers.IO) {
            taskDao.deleteTask(id)
            tasks[listName] = taskDao.getTask(listName)
        }
    }
}
