package com.harunbekcan.valorantproject.data.response

import com.google.gson.annotations.SerializedName

data class AgentResponse(
    @SerializedName("data")
    val agentList: List<AgentResponseItem>,
    @SerializedName("status")
    val status: Int
)