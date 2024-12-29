package com.example.praktikumremotedatabase

import android.app.Application
import com.example.praktikumremotedatabase.DependeciesInjection.AppContainer
import com.example.praktikumremotedatabase.DependeciesInjection.MahasiswaContainer

class MahasiswaApplications:Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container=MahasiswaContainer()
    }
}