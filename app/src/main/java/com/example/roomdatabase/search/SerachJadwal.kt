package com.example.roomdatabase.view.jadwal

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.roomdatabase.data.entity.Jadwal

@Composable
fun SearchJadwal(jadwalList: List<Jadwal>, onSearch: (String) -> Unit) {
    var query by remember { mutableStateOf("") }
    val filteredList = jadwalList.filter { it.tanggal.contains(query, ignoreCase = true) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = query,
            onValueChange = {
                query = it
                onSearch(query)
            },
            label = { Text("Cari Jadwal") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (filteredList.isEmpty()) {
            Text("Tidak ada jadwal yang ditemukan", style = MaterialTheme.typography.bodyMedium)
        } else {
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(filteredList) { jadwal ->
                    JadwalItem(jadwal)
                }
            }
        }
    }
}

@Composable
fun JadwalItem(jadwal: Jadwal) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Dokter ID: ${jadwal.dokterId}", style = MaterialTheme.typography.titleMedium)
            Text(text = "Tanggal: ${jadwal.tanggal}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Waktu: ${jadwal.waktu}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
