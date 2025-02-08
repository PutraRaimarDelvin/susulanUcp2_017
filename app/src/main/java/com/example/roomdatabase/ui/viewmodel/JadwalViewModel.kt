package com.example.roomdatabase.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.data.entity.Jadwal
import com.example.roomdatabase.repository.LocalRepoJadwal
import kotlinx.coroutines.launch

class JadwalViewModel(private val repository: LocalRepoJadwal) : ViewModel() {
    fun insertJadwal(jadwal: Jadwal) {
        viewModelScope.launch {
            repository.insertJadwal(jadwal)
        }
    }

    fun updateJadwal(jadwal: Jadwal) {
        viewModelScope.launch {
            repository.updateJadwal(jadwal)
        }
    }

    fun deleteJadwal(jadwal: Jadwal) {
        viewModelScope.launch {
            repository.deleteJadwal(jadwal)
        }
    }

    suspend fun getAllJadwal(): List<Jadwal> {
        return repository.getAllJadwal()
    }

    suspend fun getJadwalById(id: Int): Jadwal {
        return repository.getJadwalById(id)
    }
}