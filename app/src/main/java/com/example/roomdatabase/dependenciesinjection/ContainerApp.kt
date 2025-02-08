package com.example.roomdatabase.dependenciesinjection

import android.app.Application
import com.example.roomdatabase.data.database.DefaDatabase
import com.example.roomdatabase.repository.LocalRepoDr
import com.example.roomdatabase.repository.LocalRepoJadwal
import com.example.roomdatabase.viewmodel.DokterViewModel
import com.example.roomdatabase.viewmodel.JadwalViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { DefaDatabase.getDatabase(androidContext()).dokterDao() } // Inject DAO dengan Context
    single { DefaDatabase.getDatabase(androidContext()).jadwalDao() } // Inject DAO dengan Context
    single { LocalRepoDr(get()) }
    single { LocalRepoJadwal(get()) }
    viewModel { DokterViewModel(get(), get()) } // Memastikan parameter sesuai dengan constructor ViewModel
    viewModel { JadwalViewModel(get()) }
}
