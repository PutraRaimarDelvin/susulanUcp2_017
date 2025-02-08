package com.example.roomdatabase.view.jadwal

import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.roomdatabase.data.entity.Jadwal

@Composable
fun DeleteJadwal(jadwal: Jadwal, onDelete: (Jadwal) -> Unit) {
    Button(onClick = { onDelete(jadwal) }) {
        Text("Hapus Jadwal")
    }
}

@Preview
@Composable
fun PreviewDeleteJadwal() {
    DeleteJadwal(jadwal = Jadwal(dokterId = 1, tanggal = "2023-10-01", waktu = "10:00"), onDelete = {})
}