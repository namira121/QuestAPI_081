package com.example.praktikumremotedatabase.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.praktikumremotedatabase.repository.MahasiswaRepository

class InsertViewModel (private val mhs: MahasiswaRepository): ViewModel(){
    var uiState by mutableStateOf(InsertUiState())
        private set

    fun updateInsertMhsState(insertUiEvent.InsertUiEvent){
        uiState = InsertUiState(insertUiEvent = insertUiEvent)
    }
}