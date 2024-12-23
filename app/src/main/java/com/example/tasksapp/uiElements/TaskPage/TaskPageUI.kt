package com.example.tasksapp.uiElements.TaskPage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tasksapp.TaskViewModel
import com.example.tasksapp.roomdb.TaskEntity

@Composable
fun TaskPageUI(viewModel: TaskViewModel,taskEntity: TaskEntity,navController: NavController){
    var task by remember { mutableStateOf("Enter Task") }
    var details by remember { mutableStateOf(taskEntity.taskDetails) }
    Column(
        modifier = Modifier.fillMaxSize().background(Color(18,19,22)).padding(top = 32.dp)
    ) {
        //icons backarrow and threedot icon
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    navController.navigate("Start_Page")
                }
            ) {
                Icon(
                    modifier = Modifier.size(27.dp),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "",
                    tint = Color.White
                )
            }
            IconButton(
                onClick = {}
            ) {
                Icon(
                    modifier = Modifier.size(27.dp),
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
        //my tasks icon
        Row(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp).clickable {  }
        ) {
            Text(
                text = taskEntity.listName,
                color = Color(171,185,255),
                fontSize = 18.sp
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown ,
                contentDescription = "",
                tint = Color(171,185,255)
            )
        }
        Row(
            modifier = Modifier.padding(top = 16.dp, start = 16.dp)
        ) {
            TextField(
                value = taskEntity.taskEntered,
                onValueChange = {

                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(18,19,22),
                    unfocusedIndicatorColor = Color(18,19,22),
                    unfocusedContainerColor = Color(18,19,22),
                    focusedIndicatorColor = Color(18,19,22)
                )
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 8.dp, top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "",
                        tint = Color.White
                    )
                },
                value = details,
                onValueChange = {
                    details=it
                    viewModel.updateTaskDetails(it,taskEntity)

                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(18,19,22),
                    unfocusedIndicatorColor = Color(18,19,22),
                    unfocusedContainerColor = Color(18,19,22),
                    focusedIndicatorColor = Color(18,19,22)
                )
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 8.dp, top = 8.dp)
                .clickable { },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(start = 12.dp),
                imageVector = Icons.Default.DateRange,
                contentDescription = "",
                tint = Color.White
            )
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "Add date/time",
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.background(Color.Blue).fillMaxWidth().height(88.dp).background(Color(31,31,34))
        ){
            Spacer(modifier = Modifier.weight(1f))
            if(taskEntity.taskCheck){
                Text(
                    modifier = Modifier.clickable {

                    }
                        .padding(top = 28.dp),
                    text = "Mark uncompleted",
                    color = Color(171,185,255),
                    fontWeight = FontWeight.Bold
                )
            }else{
                Text(
                    modifier = Modifier.clickable {

                    }
                        .padding(top = 28.dp),
                    text = "Mark completed",
                    color = Color(171,185,255),
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}