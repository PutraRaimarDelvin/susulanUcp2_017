package com.example.roomdatabase.view.dokter

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.roomdatabase.data.entity.Dokter

@Composable
fun SearchDokter(dokterList: List<Dokter>, onSearch: (String) -> Unit) {
    var query by remember { mutableStateOf("") }
    val filteredList = dokterList.filter { it.nama.contains(query, ignoreCase = true) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = query,
            onValueChange = {
                query = it
                onSearch(query)
            },
            label = { Text("Cari Dokter") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (filteredList.isEmpty()) {
            Text("Tidak ada dokter yang ditemukan", style = MaterialTheme.typography.bodyMedium)
        } else {
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(filteredList) { dokter ->
                    DokterItem(dokter)
                }
            }
        }
    }
}

@Composable
fun DokterItem(dokter: Dokter) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = dokter.nama, style = MaterialTheme.typography.titleMedium)
            Text(text = "Spesialis: ${dokter.spesialis}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
