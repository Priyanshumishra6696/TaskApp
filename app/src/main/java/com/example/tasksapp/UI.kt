package com.example.tasksapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tasksapp.uiElements.Tabs

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UI(viewModel: TaskViewModel,navController: NavController){

    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember{ mutableStateOf(false) }
    var taskEntered by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {showBottomSheet = true}
            ) {
                Text("+", fontSize = 32.sp , fontWeight = FontWeight.Normal)
            }
        },
        modifier = Modifier
            .fillMaxSize(),
        containerColor = Color(31,31,34),
        contentColor = Color.White
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Tasks", fontSize = 24.sp)
            }
            Tabs(viewModel,navController)
        }
    }
    if(showBottomSheet){
        ModalBottomSheet(
            onDismissRequest = {
                taskEntered=""
                showBottomSheet = false },
            sheetState = sheetState,

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedTextField(
                    value = taskEntered ,
                    onValueChange = {taskEntered=it},
                    label = { Text("Enter Task") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .verticalScroll(scrollState)
                )

            }
            Button(modifier = Modifier.padding(start = 16.dp), onClick = {
                viewModel.addTask(taskEntered,viewModel.getCurrList())

                taskEntered=""
                showBottomSheet = false
            }) {
                Text("Save")
            }
        }
    }
}







