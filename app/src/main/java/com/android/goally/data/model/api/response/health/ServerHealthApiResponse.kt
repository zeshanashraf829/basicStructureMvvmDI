package com.android.goally.data.model.api.response.health

data class ServerHealthApiResponse(
    val status: String,
    val info: ServerInfo,
    val error: Any?,
    val details: ServerDetails
)
