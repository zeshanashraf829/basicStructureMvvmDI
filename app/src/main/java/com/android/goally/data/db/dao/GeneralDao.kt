package com.android.goally.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.goally.data.db.entities.token.Authentication


@Dao
interface GeneralDao {
    @Query("Select * from authentication")
    fun getAuthenticationLive(): LiveData<Authentication?>
    @Query("Select * from authentication")
    suspend fun getAuthentication(): Authentication?
}