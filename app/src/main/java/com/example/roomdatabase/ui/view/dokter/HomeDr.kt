package com.example.roomdatabase.view.dokter

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.roomdatabase.data.entity.Dokter
import com.example.roomdatabase.viewmodel.DokterViewModel

@Composable
fun HomeDr(viewModel: DokterViewModel) {
    var dokterList by remember { mutableStateOf(listOf<Dokter>()) }

    LaunchedEffect(Unit) {
        dokterList = viewModel.getAllDokter()
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Daftar Dokter", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        SearchDokter(dokterList) { query ->
            dokterList = dokterList.filter { it.nama.contains(query, ignoreCase = true) }
        }
        Spacer(modifier = Modifier.height(16.dp))
        InsertDr(onInsert = { viewModel.insertDokter(it) })
    }
}