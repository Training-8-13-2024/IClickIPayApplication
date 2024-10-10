package com.iclickipayapplication.common.local


import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.iclickipay.data.doctor.local.dao.PatientDao
import com.iclickipay.data.doctor.local.entities.PatientData
import com.iclickipay.data.learn.local.dao.TeacherBookingDao
import com.iclickipay.data.learn.local.entity.TeacherBookingEntity
import com.iclickipay.data.tinder.local.dao.TinderBookingDao
import com.iclickipay.data.tinder.local.entity.TinderProfileEntity
import com.iclickipayapplication.common.R
import dagger.hilt.android.qualifiers.ApplicationContext


@Database(entities = [PatientData::class, TeacherBookingEntity::class, TinderProfileEntity::class], version = 25, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun PatientDao(): PatientDao
    abstract fun teacherBookingDao(): TeacherBookingDao
    abstract fun tinderDao(): TinderBookingDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "App_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}