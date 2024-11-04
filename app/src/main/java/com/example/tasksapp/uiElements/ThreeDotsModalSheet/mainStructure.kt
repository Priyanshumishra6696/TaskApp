package com.example.tasksapp.uiElements.ThreeDotsModalSheet

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import com.example.tasksapp.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainStructureModalBottomSheet(viewModel: TaskViewModel,DeleteListAccessibilty:Boolean,DeleteTaskAccessibilty : Boolean){
    val sheetState = rememberModalBottomSheetState()
    if(viewModel.showModalBottomSheet.value){
        ModalBottomSheet(
            onDismissRequest = {viewModel.showModalBottomSheet.value=false},
            sheetState = sheetState
        ) {
            RenameList(viewModel)
            DeleteList(viewModel,DeleteListAccessibilty)
            DeleteCompletedTasks(viewModel,DeleteTaskAccessibilty)
        }

    }
}