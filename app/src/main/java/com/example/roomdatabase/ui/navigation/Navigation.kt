package com.example.roomdatabase.ui.navigation

import androidx.compose.runtime.*
import androidx.compose.material3.Text
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.roomdatabase.view.dokter.HomeDr
import com.example.roomdatabase.view.jadwal.HomeJadwal
import com.example.roomdatabase.view.jadwal.DetailJadwal
import com.example.roomdatabase.viewmodel.JadwalViewModel
import com.example.roomdatabase.viewmodel.DokterViewModel
import com.example.roomdatabase.data.entity.Jadwal

@Composable
fun Navigation(
    navController: NavHostController,
    jadwalViewModel: JadwalViewModel,
    dokterViewModel: DokterViewModel
) {
    NavHost(navController, startDestination = "homeDr") {
        composable("homeDr") { HomeDr(dokterViewModel) }
        composable("homeJadwal") { HomeJadwal(navController, jadwalViewModel) }
        composable("detailJadwal/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: 0
            var jadwal by remember { mutableStateOf<Jadwal?>(null) }
            var isLoading by remember { mutableStateOf(true) }

            LaunchedEffect(id) {
                val result = jadwalViewModel.getJadwalById(id) // Ambil data dari ViewModel
                jadwal = result
                isLoading = false
            }

            if (isLoading) {
                Text("Loading...") // Menampilkan loading sebelum data tersedia
            } else {
                jadwal?.let { DetailJadwal(it) } ?: Text("Jadwal tidak ditemukan")
            }
        }
    }
}
