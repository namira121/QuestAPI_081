package com.example.praktikumremotedatabase.ui.View

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.praktikumremotedatabase.ui.CustomWidget.CustomTopAppBar
import com.example.praktikumremotedatabase.ui.Navigation.DestinasiNavigasi
import com.example.praktikumremotedatabase.ui.viewModel.PenyediaViewModel
import com.example.praktikumremotedatabase.ui.viewModel.UpdateViewModel
import kotlinx.coroutines.launch

object DestinasiUpdate: DestinasiNavigasi {
    override val route = "update"
    override val titleRes = "Update Mahasiswa" // judul halaman
    const val NIM = "nim"
    val routeWithArgs = "$route/{$NIM}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateView( // untuk memperbarui data mahasiswa dengan navigasi kembali
    nim: String,
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    updateViewModel: UpdateViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "Update Mahasiswa",
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        },
        modifier = modifier
    ) { innerPadding ->
        EntryBody(
            insertUiState = updateViewModel.updateUiState,
            onSiswaValueChange  = updateViewModel::updateInsertMhsState,
            onSaveClick = {
                coroutineScope.launch {
                    updateViewModel.updateMhs()
                    onNavigateUp()
                }
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}