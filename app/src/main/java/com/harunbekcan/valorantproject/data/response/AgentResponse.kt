package com.harunbekcan.valorantproject.data.response

import com.google.gson.annotations.SerializedName

data class AgentResponse(
    @SerializedName("data")
    val data: List<AgentResponseItem>,
    @SerializedName("status")
    val status: Int
)