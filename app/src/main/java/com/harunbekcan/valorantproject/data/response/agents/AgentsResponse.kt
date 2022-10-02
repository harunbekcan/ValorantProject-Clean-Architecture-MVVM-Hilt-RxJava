package com.harunbekcan.valorantproject.data.response.agents

import com.google.gson.annotations.SerializedName

data class AgentsResponse(
    @SerializedName("data")
    val agentList: List<AgentsResponseItem>,
    @SerializedName("status")
    val status: Int
)