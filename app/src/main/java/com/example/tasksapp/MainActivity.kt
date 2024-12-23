package com.example.tasksapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.example.tasksapp.roomdb.TaskDatabase
import com.example.tasksapp.roomdb.TaskEntity
import com.example.tasksapp.ui.theme.TasksAppTheme
import com.example.tasksapp.uiElements.TaskPage.TaskPageUI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(applicationContext,TaskDatabase::class.java,"TaskDb").build()
        val taskDao = db.getTaskDao()
//        val viewModel = ViewModelProvider(this)[TaskViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            val viewModel : TaskViewModel = viewModel(factory = ViewModelFactory(taskDao))
            viewModel.selected.value=0
            TasksAppTheme {
                MyAppNavigation(viewModel)

//                TaskPageUI(viewModel, TaskEntity(id = 1, taskEntered = "nothing", taskCheck = false, listName = "my tasks"))
            }
        }
    }
}

