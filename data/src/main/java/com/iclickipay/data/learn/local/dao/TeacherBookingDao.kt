package com.iclickipay.data.learn.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import androidx.room.Query
import com.iclickipay.data.learn.local.entity.TeacherBookingEntity

@Dao
interface TeacherBookingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooking(booking: TeacherBookingEntity)

    @Query("SELECT * FROM teacher_booking WHERE id = :id")
    suspend fun getBookingById(id: Int): TeacherBookingEntity?

    @Query("SELECT * FROM teacher_booking")
    suspend fun getAllBookings(): List<TeacherBookingEntity>

    @Update
    suspend fun updateBooking(booking: TeacherBookingEntity)

    @Delete
    suspend fun deleteBooking(booking: TeacherBookingEntity)
}