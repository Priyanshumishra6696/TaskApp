package com.example.tasksapp.uiElements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.tasksapp.TaskViewModel

@Composable
fun Tabs(viewModel: TaskViewModel,navController: NavController){

    var selected by remember { mutableIntStateOf(0) }
    val tabs = viewModel.tabs

    ScrollableTabRow(
        selectedTabIndex = selected,
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color(31,31,34)
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = selected==index,
                onClick = {
                    selected=index
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
    var currentListName = tabs.getOrNull(selected)?.listName
    LaunchedEffect(currentListName) { // Trigger when currentListName changes
        currentListName?.let { viewModel.updateCurrentListName(it) }
    }
    when(selected){
        0 -> {
            StarredPage()
        }
        1 -> {
            if(viewModel.tasks["My Tasks"]?.isEmpty() == true){
                TaskPageIfEmpty()
            }else{
                viewModel.tasks["My Tasks"]?.let { TaskColumn(viewModel, it) }
            }

        }
        else -> {
            if (currentListName != null) {
                GeneralPage(viewModel, currentListName)
            }
        }
    }
}





