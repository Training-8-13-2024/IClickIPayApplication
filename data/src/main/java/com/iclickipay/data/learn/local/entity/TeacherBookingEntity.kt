package com.iclickipay.data.learn.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teacher_booking")
data class TeacherBookingEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "lesson") val lesson: String = "English",
    @ColumnInfo(name = "level") val level: String = "College",
    @ColumnInfo(name = "availability_time") val availabilityTime: Float = 14f,
    @ColumnInfo(name = "price") val price: Float = 30f,
    @ColumnInfo(name = "rating") val rating: Float = 3f,
    @ColumnInfo(name = "teacher_name") val teacherName: String = ""
)