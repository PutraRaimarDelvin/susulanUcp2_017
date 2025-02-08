package com.example.roomdatabase.view.jadwal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.roomdatabase.data.entity.Jadwal
import com.example.roomdatabase.data.entity.Dokter

@Composable
fun FilterJadwal(jadwalList: List<Jadwal>, dokterList: List<Dokter>, onFilter: (Int) -> Unit) {
    var selectedDokterId by remember { mutableStateOf(0) }
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Filter Jadwal Berdasarkan Dokter", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(8.dp))

        // TextField untuk memilih dokter
        TextField(
            value = dokterList.find { it.id == selectedDokterId }?.nama ?: "Pilih Dokter",
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true },
            label = { Text("Dokter") }
        )

        // Dropdown menu
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            dokterList.forEach { dokter ->
                DropdownMenuItem(
                    text = { Text(dokter.nama) },
                    onClick = {
                        selectedDokterId = dokter.id
                        onFilter(selectedDokterId)
                        expanded = false
                    }
                )
            }
        }
    }
}
