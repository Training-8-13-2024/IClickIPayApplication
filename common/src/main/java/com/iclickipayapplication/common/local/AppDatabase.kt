package com.iclickipayapplication.common.local


import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.iclickipayapplication.common.local.dao.PatientDao
import com.iclickipayapplication.common.local.entities.PatientData

// Define the Room Database class, listing the entities and version
//@Database(entities = [PatientData::class], version = 7, exportSchema = false)
//abstract class AppDatabase : RoomDatabase() {
//
//    // Abstract method to get access to the DAO
//    abstract fun patientDao(): PatientDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        // Function to create or return the existing database instance
//        fun getDatabase(context: Context): AppDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "app_database"
//                )
//                    .fallbackToDestructiveMigration() // Handles database schema changes
//                    .build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
//}




@Database(entities = [PatientData::class], version = 20, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun PatientDao(): PatientDao
}