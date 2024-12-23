package com.example.tasksapp.uiElements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.navOptions
import com.example.tasksapp.R
import com.example.tasksapp.TaskViewModel
import com.example.tasksapp.roomdb.TaskEntity
import com.example.tasksapp.uiElements.ThreeDotsModalSheet.MainStructureModalBottomSheet

@Composable
fun TaskColumn(
    viewModel: TaskViewModel,
    taskList: List<TaskEntity>,
    listName : String,
    navController: NavController
){
//    LazyColumn(
//        content = {
//            itemsIndexed(viewModel.taskList){index, item ->
//                TaskBlock(title = item.taskEntered)
//            }
//        }
//    )
    if(viewModel.uncompletedTasks[listName].isNullOrEmpty()){
        Displayone(viewModel, taskList,listName,navController)
    }else{
        Displaytwo(viewModel,taskList,listName,navController)
    }
    if(viewModel.getCurrList()=="My Tasks"){
        MainStructureModalBottomSheet(viewModel,true,false)
    }else {
        MainStructureModalBottomSheet(viewModel,false,false)
    }

}






@Composable
fun TaskBlock(viewModel: TaskViewModel,taskEntity: TaskEntity,title : String ,onDelete:()->Unit,navController: NavController){
    var isChecked by remember { mutableStateOf(false) }
    if(!taskEntity.taskCheck) {
        Row(
            modifier = Modifier.padding(24.dp)
                .clickable {
                    viewModel.updatecurrtask(taskEntity)
                    navController.navigate("task_ui")
                },
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
                        onDelete()
                        viewModel.updateCompletedTask(
                            completedTask = taskEntity.taskEntered,
                            listName = taskEntity.listName
                        )

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

}
@Composable
fun CompletedTaskBlock(viewModel: TaskViewModel,taskEntity: TaskEntity,title : String ,onDelete:()->Unit,navController: NavController){
    Row(
        modifier = Modifier.padding(24.dp)
            .clickable {
                viewModel.updatecurrtask(taskEntity)
                navController.navigate("task_ui")
            },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
//        Checkbox(
//            checked = isChecked,
//            onCheckedChange = {
//                onDelete()
//                isChecked=true
//            }
//        )
        Icon(
            modifier = Modifier.padding(top = 12.dp),
            imageVector = Icons.Default.Check ,
            contentDescription = "",
            tint = Color.White
        )
        Text(
            modifier = Modifier.padding(12.dp),
            text = title
        )

    }

}

@Composable
fun Displayone(viewModel: TaskViewModel, taskList: List<TaskEntity>, listName: String,navController: NavController){
    Column() {
        TaskCompleted(viewModel)
        if(!viewModel.completedTasksMapper[listName].isNullOrEmpty()) {
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Column(
                    modifier = Modifier.background(Color(18, 19, 22)).fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(start = 31.dp).height(64.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier,
                            text = "Completed",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(
                            modifier = Modifier.padding(end = 16.dp),
                            onClick = {
                                viewModel.showCompletedTasks.value = !viewModel.showCompletedTasks.value
                            }
                        ) {
                            Icon(
                                modifier = Modifier.size(31.dp),
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "",
                                tint = Color.White
                            )
                        }
                    }
                    if(viewModel.showCompletedTasks.value) {
                        LazyColumn(
                            content = {
                                val completedTasks =
                                    viewModel.completedTasksMapper[listName] ?: emptyList()
                                itemsIndexed(completedTasks) { index, item ->
                                    CompletedTaskBlock(viewModel,
                                        taskEntity = item,
                                        title = item.taskEntered,
                                        onDelete = {},
                                        navController = navController
                                    )
                                }
                            }
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun Displaytwo(viewModel: TaskViewModel, taskList: List<TaskEntity>, listName: String,navController: NavController){
    Column() {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier.background(Color(18, 19, 22))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                        text = listName,
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
                            onClick = {
                                viewModel.showModalBottomSheet.value = true
                            },
                            colors = ButtonDefaults.buttonColors(Color(18, 19, 22))
                        ) {
                            Icon(
                                Icons.Default.MoreVert,
                                contentDescription = "",
                                tint = Color.White
                            )
                        }
                    }


                }
                LazyColumn(
                    content = {
                        itemsIndexed(taskList) { index, item: TaskEntity ->
                            TaskBlock(
                                viewModel,
                                taskEntity = item,
                                title = item.taskEntered,
                                { viewModel.deleteTask(item.id, viewModel.getCurrList()) },
                                navController = navController
                            )
                        }
                    }
                )
            }

        }

        if (viewModel.completedTasksMapper[listName]?.isEmpty() == false) {
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Column(
                    modifier = Modifier.background(Color(18, 19, 22)).fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(start = 31.dp).height(64.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier,
                            text = "Completed",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(
                            modifier = Modifier.padding(end = 16.dp),
                            onClick = {
                                viewModel.showCompletedTasks.value =
                                    !viewModel.showCompletedTasks.value
                            }
                        ) {
                            Icon(
                                modifier = Modifier.size(31.dp),
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "",
                                tint = Color.White
                            )
                        }
                    }
                    if (viewModel.showCompletedTasks.value) {
                        LazyColumn(
                            content = {
                                val completedTasks =
                                    viewModel.completedTasksMapper[listName] ?: emptyList()
                                itemsIndexed(completedTasks) { index, item ->
                                    CompletedTaskBlock(viewModel,
                                        taskEntity = item,
                                        title = item.taskEntered,
                                        onDelete = {},
                                        navController
                                    )
                                }
                            }
                        )
                    }
                }

            }
        }
    }
}