package com.example.tasksapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tasksapp.uiElements.AddNewList
import com.example.tasksapp.uiElements.TaskPage.TaskPageUI

@Composable
fun MyAppNavigation(viewModel: TaskViewModel){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Start_Page",
        builder = {
            composable("Start_Page"){
                UI(viewModel,navController)
            }
            composable("Create_List_Page"){
                AddNewList(viewModel,navController)
            }
            composable("task_ui"){
                TaskPageUI(viewModel, viewModel.getCurrTask(),navController)
            }
        }
    )
}
