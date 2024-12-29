package com.example.praktikumremotedatabase.repository

import com.example.praktikumremotedatabase.model.Mahasiswa
import com.example.praktikumremotedatabase.service.MahasiswaService
import java.io.IOException

interface MahasiswaRepository{
    suspend fun getMahasiswa(): List<Mahasiswa>
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
    suspend fun updateMahasiswa(nim:String, mahasiswa: Mahasiswa)
    suspend fun deleteMahasiswa(nim: String)
    suspend fun getMahasiswabyNIM(nim: String): Mahasiswa
}

class NetworkMahasiswaRepository(
    private val MahasiswaApiService: MahasiswaService
):MahasiswaRepository{
    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {
        MahasiswaApiService.insertMahasiswa(mahasiswa)
    }

    override suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa) {
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

    override suspend fun getMahasiswa(): List<Mahasiswa> = MahasiswaApiService.getMahasiswa()

    override suspend fun getMahasiswabyNIM(nim: String): Mahasiswa {
        return MahasiswaApiService.getMahasiswaByNIM(nim)
    }
}