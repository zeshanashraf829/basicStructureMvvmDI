package com.getgoally.learnerapp.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson

class StringListConvert {

    @TypeConverter
    fun fromList(value: List<String>?): String? {
        return value?.let { Gson().toJson(it) }
    }

    @TypeConverter
    fun toList(value: String?): List<String>? {
        return value?.let {
            Gson().fromJson(value, Array<String>::class.java).toList()
        }
    }
}