package com.example.praktikumremotedatabase.ui.View

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.praktikumremotedatabase.ui.Navigation.DestinasiNavigasi
import com.example.praktikumremotedatabase.ui.viewModel.InsertViewModel
import com.example.praktikumremotedatabase.ui.viewModel.PenyediaViewModel

object DestinasiEntry: DestinasiNavigasi{
    override val route= "item_entry"
    override val titleRes = "Entry Mhs"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryMhsScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: InsertViewModel = viewModel(factory = PenyediaViewModel.Factory)
){}