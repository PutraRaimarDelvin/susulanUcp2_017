package com.example.roomdatabase.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.data.dao.DokterDao
import com.example.roomdatabase.data.dao.JadwalDao
import com.example.roomdatabase.data.entity.Dokter
import com.example.roomdatabase.data.entity.Jadwal
import android.content.Context

@Database(entities = [Dokter::class, Jadwal::class], version = 1)
abstract class DefaDatabase : RoomDatabase() {
    abstract fun dokterDao(): DokterDao
    abstract fun jadwalDao(): JadwalDao

    companion object {
        @Volatile
        private var INSTANCE: DefaDatabase? = null

        fun getDatabase(context: Context): DefaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DefaDatabase::class.java,"defa_database"
                ).build()
                INSTANCE = instance
                instance
            }  
        }
    }
}