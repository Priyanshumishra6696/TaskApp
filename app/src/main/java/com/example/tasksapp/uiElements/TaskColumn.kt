package com.example.tasksapp.uiElements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasksapp.R
import com.example.tasksapp.TaskViewModel
import com.example.tasksapp.roomdb.TaskEntity

@Composable
fun TaskColumn(viewModel: TaskViewModel,taskList : List<TaskEntity>){
//    LazyColumn(
//        content = {
//            itemsIndexed(viewModel.taskList){index, item ->
//                TaskBlock(title = item.taskEntered)
//            }
//        }
//    )
    Column(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier.background(Color(18,19,22))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                    text = "My Tasks",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Row {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color(18, 19, 22))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img),
                            contentDescription = "sort image",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color(18, 19, 22))
                    ) {
                        Icon(Icons.Default.MoreVert, contentDescription = "", tint = Color.White)
                    }
                }


            }
            LazyColumn(
                content = {
                    itemsIndexed(taskList) { index, item: TaskEntity ->
                        TaskBlock(title = item.taskEntered, { viewModel.deleteTask(item.id,viewModel.getCurrList())})
                    }
                }
            )
        }
    }
}

//@Composable
//fun TaskBlock(title:String,onDelete : ()->Unit){
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//    ) {
//        Text(title, color = Color.White)
//        IconButton(onClick = onDelete) {
//            Icon(Icons.Default.Delete, contentDescription = "")
//        }
//    }
//}

@Composable
fun TaskPageCoverUp(){
    Column(
        modifier = Modifier.background(Color(18,19,22))
    ) {

    }
}

@Composable
fun TaskBlock(title : String ,onDelete:()->Unit){
    var isChecked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.padding(24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
//        Checkbox(
//            checked = isChecked,
//            onCheckedChange = {
//                onDelete()
//                isChecked=true
//            }
//        )
        RadioButton(
            selected = isChecked,
            onClick = {
                isChecked = !isChecked // Toggle the state
                if (isChecked) {
                    onDelete() // Call onDelete when the radio button is selected
                    isChecked = !isChecked
                }
            }
        )
        Text(
            modifier = Modifier.padding(12.dp),
            text = title
        )

    }

}

