package com.example.roomdatabase.repository

import com.example.roomdatabase.data.dao.JadwalDao
import com.example.roomdatabase.data.entity.Jadwal

class LocalRepoJadwal(private val jadwalDao: JadwalDao) {
    suspend fun insertJadwal(jadwal: Jadwal) {
        jadwalDao.insertJadwal(jadwal)
    }

    suspend fun getAllJadwal(): List<Jadwal> {
        return jadwalDao.getAllJadwal()
    }

    suspend fun updateJadwal(jadwal: Jadwal) {
        jadwalDao.updateJadwal(jadwal)
    }

    suspend fun deleteJadwal(jadwal: Jadwal) {
        jadwalDao.deleteJadwal(jadwal)
    }

    suspend fun getJadwalById(id: Int): Jadwal {
        return jadwalDao.getJadwalById(id)
    }
}