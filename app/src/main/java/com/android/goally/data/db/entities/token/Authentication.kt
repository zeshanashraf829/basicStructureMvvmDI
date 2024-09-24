package com.android.goally.data.db.entities.token

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class Authentication(
    @ColumnInfo
    @PrimaryKey(autoGenerate = false)
    @SerializedName("_id")
    val id: Int = 0,
    @ColumnInfo @SerializedName("token") var token: String? = null,
    @ColumnInfo @SerializedName("name") val name: String,
)