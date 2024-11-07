package com.example.tasksapp.uiElements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
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
import com.example.tasksapp.R
import com.example.tasksapp.TaskViewModel
import com.example.tasksapp.uiElements.ThreeDotsModalSheet.MainStructureModalBottomSheet

@Composable
fun StarredPage() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f)
//            .fillMaxSize()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp)) // Apply the rounded corners
            .background(
                Color(
                    18,
                    19,
                    22
                )
            ) // Apply background after clip to round the background as well
            .padding(16.dp) // Padding inside the rounded column
    ) {
        // "Starred" text at the top-left
        Row(
            modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                text = "Starred",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(Color(18,19,22))
            ){
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "sort image",
                    modifier = Modifier.size(20.dp)
                )
            }

        }
//        Text(
//            modifier = Modifier.align(Alignment.Start),
//            text = "Starred",
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.White
//        )

        // Spacer to provide space between the "Starred" text and the rest
        Spacer(modifier = Modifier.height(16.dp))

        // Centered Image and text below
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f / 1.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.mainpagegirl),
                contentDescription = "when page is empty",
                modifier = Modifier
                    .size(200.dp)
            )
            Text(
                modifier = Modifier.padding(top = 32.dp, bottom = 24.dp),
                text = "No starred tasks",
                fontSize = 24.sp,
                color = Color.White
            )
            Text(text = "Mark important tasks with a", color = Color.White)
            Text(text = "star so you can easily find", color = Color.White)
            Text(text = "them here", color = Color.White)
        }
    }
}


@Composable
fun TaskPageIfEmpty(viewModel: TaskViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f)
//            .fillMaxSize()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp)) // Apply the rounded corners
            .background(
                Color(
                    18,
                    19,
                    22
                )
            ) // Apply background after clip to round the background as well
            .padding(16.dp) // Padding inside the rounded column
    ) {
        // "Starred" text at the top-left
        Row(
            modifier = Modifier.fillMaxWidth() ,
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
                    colors = ButtonDefaults.buttonColors(Color(18,19,22))
                ){
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
                    colors = ButtonDefaults.buttonColors(Color(18,19,22))
                ){
                    Icon(Icons.Default.MoreVert, contentDescription = "", tint = Color.White)
                }
            }


        }
//        Text(
//            modifier = Modifier.align(Alignment.Start),
//            text = "Starred",
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.White
//        )

        // Spacer to provide space between the "Starred" text and the rest
        Spacer(modifier = Modifier.height(16.dp))

        // Centered Image and text below
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f / 1.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.taskpageimg),
                contentDescription = "when page is empty",
                modifier = Modifier
                    .size(200.dp)
            )
            Text(
                modifier = Modifier.padding(top = 32.dp, bottom = 24.dp),
                text = "No tasks yet",
                fontSize = 24.sp,
                color = Color.White
            )
            Text(text = "Add your to-dos and keep", color = Color.White)
            Text(text = "track of them across Google", color = Color.White)
            Text(text = "Workspace", color = Color.White)
        }
    }
//    if(viewModel.showModalBottomSheet.value){
//        ModalBottomSheet(
//            onDismissRequest = {viewModel.showModalBottomSheet.value=false},
//            sheetState = sheetState
//        ) {
//            Row(
//                modifier = Modifier.fillMaxWidth().clickable {  }.height(64.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ){
//                Text(
//                    text = "Rename list",
//                    color = Color.White,
//                    modifier = Modifier.padding(start = 16.dp),
//                    fontSize = 18.sp
//                )
//            }
//            Row(
//                modifier = Modifier.fillMaxWidth().clickable {  }.height(64.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ){
//                Column {
//                    Text(
//                        text = "Delete list",
//                        color = Color.White,
//                        modifier = Modifier.padding(start = 16.dp),
//                        fontSize = 18.sp
//                    )
//                    Text(
//                        text = "Default list can't be deleted",
//                        color = Color.White,
//                        modifier = Modifier.padding(start = 16.dp),
//                        fontSize = 13.sp
//                    )
//                }
//            }
//            Row(
//                modifier = Modifier.fillMaxWidth().clickable {  }.height(64.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ){
//                Text(
//                    text = "Deleted all completed tasks",
//                    color = Color.White,
//                    modifier = Modifier.padding(start = 16.dp),
//                    fontSize = 18.sp
//                )
//            }
//        }
//    }
    MainStructureModalBottomSheet(viewModel,true,true)
}

@Composable
fun GeneralPage(viewModel: TaskViewModel,listName: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f)
//            .fillMaxSize()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp)) // Apply the rounded corners
            .background(
                Color(
                    18,
                    19,
                    22
                )
            ) // Apply background after clip to round the background as well
            .padding(16.dp) // Padding inside the rounded column
    ) {
        // "Starred" text at the top-left
        Row(
            modifier = Modifier.fillMaxWidth() ,
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
                    colors = ButtonDefaults.buttonColors(Color(18,19,22))
                ){
                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "sort image",
                        modifier = Modifier.size(20.dp)
                    )
                }
                Button(
                    onClick = {
                        viewModel.showModalBottomSheet.value=true
//                        viewModel.deletelist(listName)
//                        viewModel.selected.value=0
                    },
                    colors = ButtonDefaults.buttonColors(Color(18,19,22))
                ){
                    Icon(Icons.Default.MoreVert, contentDescription = "", tint = Color.White)
                }
            }


        }
//        Text(
//            modifier = Modifier.align(Alignment.Start),
//            text = "Starred",
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.White
//        )

        // Spacer to provide space between the "Starred" text and the rest
        Spacer(modifier = Modifier.height(16.dp))

        // Centered Image and text below
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f / 1.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.taskpageimg),
                contentDescription = "when page is empty",
                modifier = Modifier
                    .size(200.dp)
            )
            Text(
                modifier = Modifier.padding(top = 32.dp, bottom = 24.dp),
                text = "No tasks yet",
                fontSize = 24.sp,
                color = Color.White
            )
            Text(text = "Add your to-dos and keep", color = Color.White)
            Text(text = "track of them across Google", color = Color.White)
            Text(text = "Workspace", color = Color.White)
        }
    }
    MainStructureModalBottomSheet(viewModel,false,false)
}

@Composable
fun TaskCompleted(viewModel: TaskViewModel){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f)
//            .fillMaxSize()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp)) // Apply the rounded corners
            .background(
                Color(
                    18,
                    19,
                    22
                )
            ) // Apply background after clip to round the background as well
            .padding(16.dp) // Padding inside the rounded column
    ) {
        // "Starred" text at the top-left
        Row(
            modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                text = viewModel.getCurrList(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Row {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(Color(18,19,22))
                ){
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
                    colors = ButtonDefaults.buttonColors(Color(18,19,22))
                ){
                    Icon(Icons.Default.MoreVert, contentDescription = "", tint = Color.White)
                }
            }


        }
//        Text(
//            modifier = Modifier.align(Alignment.Start),
//            text = "Starred",
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.White
//        )

        // Spacer to provide space between the "Starred" text and the rest
        Spacer(modifier = Modifier.height(16.dp))

        // Centered Image and text below
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f / 1.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.taskcompleted),
                contentDescription = "when page is empty",
                modifier = Modifier
                    .size(200.dp)
            )
            Text(
                modifier = Modifier.padding(top = 32.dp, bottom = 24.dp),
                text = "All tasks completed",
                fontSize = 24.sp,
                color = Color.White
            )
            Text(text = "Nice work!", color = Color.White)
//            Text(text = "track of them across Google", color = Color.White)
//            Text(text = "Workspace", color = Color.White)
        }
    }
//    if(viewModel.showModalBottomSheet.value){
//        ModalBottomSheet(
//            onDismissRequest = {viewModel.showModalBottomSheet.value=false},
//            sheetState = sheetState
//        ) {
//            Row(
//                modifier = Modifier.fillMaxWidth().clickable {  }.height(64.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ){
//                Text(
//                    text = "Rename list",
//                    color = Color.White,
//                    modifier = Modifier.padding(start = 16.dp),
//                    fontSize = 18.sp
//                )
//            }
//            Row(
//                modifier = Modifier.fillMaxWidth().clickable {  }.height(64.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ){
//                Column {
//                    Text(
//                        text = "Delete list",
//                        color = Color.White,
//                        modifier = Modifier.padding(start = 16.dp),
//                        fontSize = 18.sp
//                    )
//                    Text(
//                        text = "Default list can't be deleted",
//                        color = Color.White,
//                        modifier = Modifier.padding(start = 16.dp),
//                        fontSize = 13.sp
//                    )
//                }
//            }
//            Row(
//                modifier = Modifier.fillMaxWidth().clickable {  }.height(64.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ){
//                Text(
//                    text = "Deleted all completed tasks",
//                    color = Color.White,
//                    modifier = Modifier.padding(start = 16.dp),
//                    fontSize = 18.sp
//                )
//            }
//        }
//    }
    MainStructureModalBottomSheet(viewModel,true,true)
}