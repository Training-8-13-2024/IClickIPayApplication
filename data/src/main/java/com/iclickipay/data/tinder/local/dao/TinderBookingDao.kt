package com.iclickipay.data.tinder.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.iclickipay.data.learn.local.entity.TeacherBookingEntity
import com.iclickipay.data.tinder.local.entity.TinderProfileEntity

@Dao
interface TinderBookingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(booking: TinderProfileEntity)

    @Query("SELECT * FROM tinder WHERE id = :id")
    suspend fun getDataById(id: Int): TinderProfileEntity?

    @Query("SELECT * FROM tinder")
    suspend fun getAllData(): List<TinderProfileEntity>

    @Update
    suspend fun updateData(booking: TinderProfileEntity)

    @Delete
    suspend fun deleteData(booking: TinderProfileEntity)
}