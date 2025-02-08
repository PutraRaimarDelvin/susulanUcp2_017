package com.example.roomdatabase.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jadwal")
data class Jadwal(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val dokterId: Int,
    val tanggal: String,
    val waktu: String
)