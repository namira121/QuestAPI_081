package com.example.praktikumremotedatabase.DependeciesInjection

import com.example.praktikumremotedatabase.repository.MahasiswaRepository

interface AppContainer{
    val mahasiswaRepository: MahasiswaRepository
}

class MahasiswaContainer: AppContainer{
    private val baseUrl ="http://10.0.2.2:8000/umyTI/"
}