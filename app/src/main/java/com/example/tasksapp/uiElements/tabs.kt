package com.example.tasksapp.uiElements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.tasksapp.TaskViewModel
import com.example.tasksapp.roomdb.TaskEntity

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
                    viewModel.showCompletedTasks.value= false
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
            if(viewModel.tasks["My Tasks"].isNullOrEmpty() && viewModel.completedTasksMapper["My Tasks"].isNullOrEmpty()){
                TaskPageIfEmpty(viewModel)
            }else{
                viewModel.tasks["My Tasks"]?.let { TaskColumn(viewModel, it,"My Tasks",navController) }
            }

        }
        (viewModel.selected.value>1) -> {
//            if(viewModel.tasks[viewModel.getCurrList()]?.isEmpty() == false){
//                viewModel.tasks[viewModel.getCurrList()]?.let{ TaskColumn(viewModel,it) }
//            }
//            else if(viewModel.tasks[viewModel.getCurrList()]?.isEmpty() == true){
//                GeneralPage(viewModel, viewModel.currentListName.value)
//            }

            if (viewModel.tasks[viewModel.getCurrList()].isNullOrEmpty() && viewModel.completedTasksMapper[viewModel.getCurrList()].isNullOrEmpty()) {
                GeneralPage(viewModel, viewModel.currentListName.value)

            } else {
                viewModel.tasks[viewModel.getCurrList()]?.let{TaskColumn(
                    viewModel, it, viewModel.getCurrList(),
                    navController = navController
                )}
            }
        }
        else -> {
            Text("errororororoororor", color = Color.White)
        }


    }
}






