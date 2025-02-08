package com.example.roomdatabase.view.dokter

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.roomdatabase.data.entity.Dokter

@Composable
fun InsertDr(onInsert: (Dokter) -> Unit) {
    var nama by remember { mutableStateOf("") }
    var spesialis by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama Dokter") }
        )
        TextField(
            value = spesialis,
            onValueChange = { spesialis = it },
            label = { Text("Spesialis") }
        )
        Button(onClick = {
            if (nama.isBlank() || spesialis.isBlank()) {
                errorMessage = "Semua field harus diisi"
            } else {
                onInsert(Dokter(nama = nama, spesialis = spesialis))
                nama = ""
                spesialis = ""
                errorMessage = ""
            }
        }) {
            Text("Simpan")
        }
        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
        }
    }
}