package com.example.tasksapp.uiElements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.tasksapp.TaskViewModel

@Composable
fun CompletedTasksUI(viewModel: TaskViewModel){
    Column {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Completed")
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = {}
            ) {
                Icons.Default.ArrowDropDown
            }
        }
    }
}