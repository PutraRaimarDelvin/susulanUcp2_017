package com.example.roomdatabase.view.jadwal

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.roomdatabase.data.entity.Jadwal

@Composable
fun UpdateJadwal(jadwal: Jadwal, onUpdate: (Jadwal) -> Unit) {
    var tanggal by remember { mutableStateOf(jadwal.tanggal) }
    var waktu by remember { mutableStateOf(jadwal.waktu) }
    var errorMessage by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = tanggal,
            onValueChange = { tanggal = it },
            label = { Text("Tanggal") }
        )
        TextField(
            value = waktu,
            onValueChange = { waktu = it },
            label = { Text("Waktu") }
        )
        Button(onClick = {
            if (tanggal.isBlank() || waktu.isBlank()) {
                errorMessage = "Semua field harus diisi"
            } else {
                onUpdate(jadwal.copy(tanggal = tanggal, waktu = waktu))
                tanggal = ""
                waktu = ""
                errorMessage = ""
            }
        }) {
            Text("Update")
        }
        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
        }
    }
}