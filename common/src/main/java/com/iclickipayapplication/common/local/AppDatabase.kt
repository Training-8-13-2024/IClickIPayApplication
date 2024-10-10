package com.iclickipayapplication.common.local


import androidx.room.Database
import androidx.room.RoomDatabase
import com.iclickipay.data.doctor.local.dao.PatientDao
import com.iclickipay.data.doctor.local.entities.PatientData


@Database(entities = [PatientData::class], version = 24, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun PatientDao(): PatientDao
}