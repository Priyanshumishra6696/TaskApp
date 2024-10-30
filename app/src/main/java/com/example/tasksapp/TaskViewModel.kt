package com.example.tasksapp

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
    var currentListName = mutableStateOf("")
    fun updateCurrentListName(newListName: String) {
        currentListName.value = newListName
    }


    init {
        viewModelScope.launch {
            tabs.add(ListEntity("Starred"))
            tabs.add(ListEntity("My Tasks"))
            tabs.addAll(taskDao.getlist())
            for (tab in tabs) {
                tasks[tab.listName] = taskDao.getTask(tab.listName)
            }
        }
    }
    fun addTask(taskEntered :String,listName: String){
        viewModelScope.launch {
            taskDao.addTask(TaskEntity(taskEntered = taskEntered, listName = listName))
            tasks[listName] = taskDao.getTask(listName)
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


    fun deleteTask(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
//            taskDao.deleteTask(id)
        }
    }
}
