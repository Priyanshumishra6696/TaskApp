package com.example.tasksapp.uiElements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.tasksapp.TaskViewModel

@Composable
fun Tabs(viewModel: TaskViewModel,navController: NavController){

    val tabs = viewModel.tabs

    ScrollableTabRow(
        selectedTabIndex = viewModel.selected.value,
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color(31,31,34)
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = viewModel.selected.value==index,
                onClick = {
                    viewModel.selected.value=index
                    viewModel.updateCurrentListName(title.listName)
                },
                text = { Text(title.listName) }
            )
        }

        Tab(
            selected = false,
            onClick = {
                navController.navigate("Create_List_Page")
            },
            text = { Text(text = "+ New List") }
        )
    }
//    var currentListName = tabs.getOrNull(selected)?.listName
//    LaunchedEffect(currentListName) { // Trigger when currentListName changes
//        currentListName?.let { viewModel.updateCurrentListName(it) }
//    }
//    currentListName?.let { viewModel.updateCurrentListName(it) }
    when(true){
        (viewModel.selected.value == 0) -> {
            StarredPage()
        }
        (viewModel.selected.value==1) -> {
            if(viewModel.tasks["My Tasks"]?.isEmpty() == true){
                TaskPageIfEmpty(viewModel)
            }else{
                viewModel.tasks["My Tasks"]?.let { TaskColumn(viewModel, it) }
            }

        }
        (viewModel.selected.value>1) -> {
//            if(viewModel.tasks[viewModel.getCurrList()]?.isEmpty() == false){
//                viewModel.tasks[viewModel.getCurrList()]?.let{ TaskColumn(viewModel,it) }
//            }
//            else if(viewModel.tasks[viewModel.getCurrList()]?.isEmpty() == true){
//                GeneralPage(viewModel, viewModel.currentListName.value)
//            }
            val currentList = viewModel.getCurrList()
            val tasks = viewModel.tasks[currentList]

            if (!tasks.isNullOrEmpty()) {
                TaskColumn(viewModel, tasks)
            } else {
                GeneralPage(viewModel, viewModel.currentListName.value)
            }
        }
        else -> {
            Text("errororororoororor", color = Color.White)
        }


    }
}






