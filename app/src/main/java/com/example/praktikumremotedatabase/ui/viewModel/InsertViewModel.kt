package com.example.praktikumremotedatabase.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktikumremotedatabase.model.Mahasiswa
import com.example.praktikumremotedatabase.repository.MahasiswaRepository
import kotlinx.coroutines.launch

class InsertViewModel (private val mhs: MahasiswaRepository): ViewModel(){
    var uiState by mutableStateOf(InsertUiState())
        private set

    fun updateInsertMhsState(insertUiEvent.InsertUiEvent){
        uiState = InsertUiState(insertUiEvent = insertUiEvent)
    }

    suspend fun insertMhs(){
        viewModelScope.launch {
            try{
                mhs.insertMahasiswa(uiState.insertUiEvent.toMhas())
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}

data class InsertUiState(
    val insertUiEvent: InsertUiEvent = InsertUiEvent()
)

data class InsertUiEvent(
    val nim: String = "",
    val nama: String = "",
    val alamat: String = "",
    val jenisKelamin: String = "",
    val kelas: String = "",
    val angkatan: String = ""
)

fun InsertUiEvent.toMhs(): Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    alamat = alamat,
    jenisKelamin = jenisKelamin,
    kelas = kelas,
    angkatan = angkatan
)