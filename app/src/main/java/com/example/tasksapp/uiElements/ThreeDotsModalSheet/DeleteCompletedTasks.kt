package com.example.tasksapp.uiElements.ThreeDotsModalSheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasksapp.TaskViewModel

@Composable
fun DeleteCompletedTasks(viewModel: TaskViewModel,notAccessible : Boolean){
    if(notAccessible){
        Row(
            modifier = Modifier.fillMaxWidth().height(64.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Delete all completed tasks",
                color = Color(108,111,117),
                modifier = Modifier.padding(start = 16.dp),
                fontSize = 18.sp
            )
        }
    }else{
        Row(
            modifier = Modifier.fillMaxWidth().clickable {
                viewModel.deleteCompletedTaskOfList(viewModel.getCurrList())
                viewModel.showModalBottomSheet.value = false
            }.height(64.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Delete all completed tasks",
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp),
                fontSize = 18.sp
            )
        }
    }

}