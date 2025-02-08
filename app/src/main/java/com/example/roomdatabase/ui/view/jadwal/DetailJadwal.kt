package com.example.roomdatabase.view.jadwal

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.roomdatabase.data.entity.Jadwal

@Composable
fun DetailJadwal(jadwal: Jadwal) {
    Text(text = "Detail Jadwal")
    Text(text = "Dokter ID: ${jadwal.dokterId}")
    Text(text = "Tanggal: ${jadwal.tanggal}")
    Text(text = "Waktu: ${jadwal.waktu}")
}