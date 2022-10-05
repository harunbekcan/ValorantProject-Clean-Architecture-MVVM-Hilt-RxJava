package com.harunbekcan.valorantproject.data.response.tiers

import com.google.gson.annotations.SerializedName

data class CompetitiveTierResponse(
    @SerializedName("assetObjectName")
    val assetObjectName: String,
    @SerializedName("assetPath")
    val assetPath: String,
    @SerializedName("tiers")
    val tiers: List<CompetitiveTierResponseItem>,
    @SerializedName("uuid")
    val uuid: String
)