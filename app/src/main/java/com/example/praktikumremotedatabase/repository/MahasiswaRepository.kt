package com.example.praktikumremotedatabase.repository

import com.example.praktikumremotedatabase.model.mahasiswa
import com.example.praktikumremotedatabase.service.MahasiswaService
import java.io.IOException

interface MahasiswaRepository{
    suspend fun getMahasiswa(): List<mahasiswa>
    suspend fun insertMahasiswa(mahasiswa: mahasiswa)
    suspend fun updateMahasiswa(nim:String, mahasiswa: mahasiswa)
    suspend fun deleteMahasiswa(nim: String)
    suspend fun getMahasiswaByNIM(nim: String): mahasiswa
}

class NetworkMahasiswaRepository(
    private val MahasiswaApiService: MahasiswaService
):MahasiswaRepository{
    override suspend fun insertMahasiswa(mahasiswa: mahasiswa) {
        MahasiswaApiService.insertMahasiswa(mahasiswa)
    }

    override suspend fun updateMahasiswa(nim: String, mahasiswa: mahasiswa) {
        MahasiswaApiService.updateMahasiswa(nim, mahasiswa)
    }

    override suspend fun deleteMahasiswa(nim: String) {
        try{
            val response = MahasiswaApiService.deleteMahasiswa(nim)
            if(!response.isSuccessful){
                throw IOException("Failed to delete Mahasiswa, HTTP status code: " +
                "${response.code()}")
            }else{
                response.message()
                println(response.message())
            }
        }catch (e:Exception){
            throw e
        }
    }

    override suspend fun getMahasiswa(): List<mahasiswa> = MahasiswaApiService.getMahasiswa()

    override suspend fun getMahasiswaByNIM(nim: String): mahasiswa {
        return MahasiswaApiService.getMahasiswaByNIM(nim)
    }
}