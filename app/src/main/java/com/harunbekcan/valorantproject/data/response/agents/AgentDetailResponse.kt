package com.harunbekcan.valorantproject.data.response.agents

import com.google.gson.annotations.SerializedName

data class AgentDetailResponse(
    @SerializedName("data")
    val data: AgentsResponseItem,
    @SerializedName("status")
    val status: Int
)