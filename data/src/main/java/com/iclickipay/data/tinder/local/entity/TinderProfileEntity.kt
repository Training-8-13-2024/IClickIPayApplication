package com.iclickipay.data.tinder.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tinder")
data class TinderProfileEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "description") val description: String = "English",
    @ColumnInfo(name = "city") val city: String = "College",
    @ColumnInfo(name = "dob") val dob: String = "College",
)