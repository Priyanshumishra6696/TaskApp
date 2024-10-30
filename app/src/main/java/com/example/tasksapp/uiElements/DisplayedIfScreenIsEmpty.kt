package com.example.tasksapp.uiElements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun TaskPageIfEmpty() {
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
                    onClick = {},
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
                        viewModel.deletelist(listName)
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
}