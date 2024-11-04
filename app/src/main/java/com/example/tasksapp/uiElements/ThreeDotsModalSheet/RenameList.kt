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
fun RenameList(viewModel: TaskViewModel){
    Row(
        modifier = Modifier.fillMaxWidth().clickable {  }.height(64.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "Rename list",
            color = Color.White,
            modifier = Modifier.padding(start = 16.dp),
            fontSize = 18.sp
        )
    }
}