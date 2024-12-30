package com.example.praktikumremotedatabase.ui.viewModel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.transition.Transition
import com.example.praktikumremotedatabase.MahasiswaApplications

object PenyediaViewModel{
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiMahasiswa().container.mahasiswaRepository)}
        initializer { InsertViewModel(aplikasiMahasiswa().container.mahasiswaRepository)}
        initializer { DetailViewModel(createSavedStateHandle(),MahasiswaApplications().container.mahasiswaRepository)}
    }
    fun CreationExtras.aplikasiMahasiswa():MahasiswaApplications =
        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications)
}

//object PenyediaViewModel {
//    val Factory = viewModelFactory {
//        initializer {
//            val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications
//            HomeViewModel(app.container.mahasiswaRepository)
//        }
//        initializer {
//            val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications
//            InsertViewModel(app.container.mahasiswaRepository)
//        }
//        initializer {
//            val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications
//            DetailViewModel(createSavedStateHandle(), app.container.mahasiswaRepository)
//        }
//    }
//}