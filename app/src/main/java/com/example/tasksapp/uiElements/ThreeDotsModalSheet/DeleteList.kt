package com.example.tasksapp.uiElements.ThreeDotsModalSheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
fun DeleteList(viewModel: TaskViewModel,notAccessible: Boolean){
    if(notAccessible){
        Row(
            modifier = Modifier.fillMaxWidth().height(64.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column {
                Text(
                    text = "Delete list",
                    color = Color(108,111,117),
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 18.sp
                )
                Text(
                    text = "Default list can't be deleted",
                    color = Color(108,111,117),
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 13.sp
                )
            }
        }
    }else{
        Row(
            modifier = Modifier.fillMaxWidth().clickable {
                viewModel.selected.value=0
                viewModel.showModalBottomSheet.value=false
                viewModel.deletelist(viewModel.getCurrList())
            }.height(64.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Delete list",
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp),
                fontSize = 18.sp
            )
        }
    }


}