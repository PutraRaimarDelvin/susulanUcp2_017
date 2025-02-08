package com.example.roomdatabase.repository

import com.example.roomdatabase.data.dao.DokterDao
import com.example.roomdatabase.data.entity.Dokter

class LocalRepoDr(private val dokterDao: DokterDao) {
    suspend fun insertDokter(dokter: Dokter) {
        dokterDao.insertDokter(dokter)
    }

    suspend fun getAllDokter(): List<Dokter> {
        return dokterDao.getAllDokter()
    }
}