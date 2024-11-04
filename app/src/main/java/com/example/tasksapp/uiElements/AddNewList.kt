package com.example.tasksapp.uiElements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tasksapp.TaskViewModel

@Composable
fun AddNewList(viewModel: TaskViewModel,navController: NavController){
    var text by remember { mutableStateOf("") }
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize().padding(it).background(Color(18,19,22))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = {
                        navController.navigate("Start_Page")
                    }
                ) {
                    Icon(Icons.Default.Close, contentDescription = "")
                }

                Text(modifier = Modifier.padding(top = 10.dp), text = "Create new list", fontSize = 24.sp)

                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = {
                        viewModel.selected.value = viewModel.tabs.size
                        viewModel.addList(text)
                        viewModel.updateCurrentListName(text)
                        navController.navigate("Start_Page")
                    },
                    colors = ButtonDefaults.buttonColors(Color(18,19,22))
                    ) {
                    Text(
                        text="Done",
                        color = Color.White
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    value = text,
                    onValueChange = {text = it},
                    label = { Text("Enter list title") }
                )
            }

        }
    }
}