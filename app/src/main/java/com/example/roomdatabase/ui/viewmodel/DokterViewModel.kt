package com.example.roomdatabase.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.data.entity.Dokter
import com.example.roomdatabase.repository.LocalRepoDr
import kotlinx.coroutines.launch

class DokterViewModel(private val repository: LocalRepoDr) : ViewModel() {
    fun insertDokter(dokter: Dokter) {
        viewModelScope.launch {
            repository.insertDokter(dokter)
        }
    }

    suspend fun getAllDokter(): List<Dokter> {
        return repository.getAllDokter()
    }
}