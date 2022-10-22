package com.harunbekcan.valorantproject.data.response.maps

import com.google.gson.annotations.SerializedName

data class MapDetailResponse(
    @SerializedName("data")
    val data: MapsResponseItem,
    @SerializedName("status")
    val status: Int
)