package com.example.roomdatabase.view.jadwal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roomdatabase.data.entity.Dokter
import com.example.roomdatabase.data.entity.Jadwal
import com.example.roomdatabase.viewmodel.JadwalViewModel

@Composable
fun HomeJadwal(viewModel: JadwalViewModel, navController: NavController, dokterList: List<Dokter>) {
    var jadwalList by remember { mutableStateOf(listOf<Jadwal>()) }

    LaunchedEffect(Unit) {
        jadwalList = viewModel.getAllJadwal()
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Daftar Jadwal", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        jadwalList.forEach { jadwal ->
            Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                Text(
                    text = "Dokter ID: ${jadwal.dokterId}, Tanggal: ${jadwal.tanggal}, Waktu: ${jadwal.waktu}",
                    modifier = Modifier.weight(1f).clickable { navController.navigate("detailJadwal/${jadwal.id}") }
                )
                DeleteJadwal(jadwal) { viewModel.deleteJadwal(jadwal) }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        InsertJadwal(onInsert = { viewModel.insertJadwal(it) }, dokterList = dokterList)
    }
}