package com.android.goally.data.repo

import com.android.goally.data.db.dao.GeneralDao
import com.android.goally.data.db.entities.token.Authentication
import com.android.goally.data.network.rest.api.GeneralApi


class GeneralRepo(
    private val generalApi: GeneralApi,
    private val generalDao: GeneralDao,
) {

    suspend fun checkHealth() = generalApi.checkHealth()
    suspend fun getToken(userEmail:String) = generalApi.getToken(userEmail)


    fun getAuthenticationLive() = generalDao.getAuthenticationLive()
    suspend fun getAuthentication() = generalDao.getAuthentication()

}