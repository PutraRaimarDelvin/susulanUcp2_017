package com.example.roomdatabase.view.jadwal

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.roomdatabase.data.entity.Jadwal
import com.example.roomdatabase.data.entity.Dokter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsertJadwal(onInsert: (Jadwal) -> Unit, dokterList: List<Dokter>) {
    var dokterId by remember { mutableStateOf(0) }
    var tanggal by remember { mutableStateOf("") }
    var waktu by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) } // Kontrol dropdown
    var selectedDokterName by remember { mutableStateOf("Pilih Dokter") } // Menampilkan dokter yang dipilih

    Column(modifier = Modifier.padding(16.dp)) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = it }
        ) {
            TextField(
                value = selectedDokterName,
                onValueChange = {},
                readOnly = true,
                label = { Text("Dokter") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                dokterList.forEach { dokter ->
                    DropdownMenuItem(
                        text = { Text(dokter.nama) },
                        onClick = {
                            dokterId = dokter.id
                            selectedDokterName = dokter.nama
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = tanggal,
            onValueChange = { tanggal = it },
            label = { Text("Tanggal") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = waktu,
            onValueChange = { waktu = it },
            label = { Text("Waktu") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (dokterId == 0 || tanggal.isBlank() || waktu.isBlank()) {
                errorMessage = "Semua field harus diisi"
            } else {
                onInsert(Jadwal(dokterId = dokterId, tanggal = tanggal, waktu = waktu))
                dokterId = 0
                tanggal = ""
                waktu = ""
                selectedDokterName = "Pilih Dokter"
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
