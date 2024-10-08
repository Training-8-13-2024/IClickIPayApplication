package com.iclickipayapplication.common.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.iclickipayapplication.common.local.models.Injury

object Converters {
    @TypeConverter
    fun fromStringList(value: List<String>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toStringList(value: String?): List<String>? {
        val listType = object : com.google.gson.reflect.TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromInjuryList(value: List<Injury>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toInjuryList(value: String?): List<Injury>? {
        val listType = object : com.google.gson.reflect.TypeToken<List<Injury>>() {}.type
        return Gson().fromJson(value, listType)
    }
}