package com.harunbekcan.valorantproject.data.response.tiers

import com.google.gson.annotations.SerializedName

data class TiersResponse(
    @SerializedName("data")
    val data: List<CompetitiveTierResponse>,
    @SerializedName("status")
    val status: Int
)