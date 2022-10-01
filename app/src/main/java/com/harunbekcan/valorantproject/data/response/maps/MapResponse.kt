package com.harunbekcan.valorantproject.data.response.maps

import com.google.gson.annotations.SerializedName

data class MapResponse(
    @SerializedName("data")
    val data: List<MapResponseItem>,
    @SerializedName("status")
    val status: Int
)