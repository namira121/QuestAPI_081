package com.example.praktikumremotedatabase.ui.viewModel

import com.example.praktikumremotedatabase.model.Mahasiswa

sealed class HomeUiState{
    data class Success(val mahasiswa: List<Mahasiswa>) : HomeUiState()
    object Error : HomeUiState()
    object Loading : HomeUiState()
}