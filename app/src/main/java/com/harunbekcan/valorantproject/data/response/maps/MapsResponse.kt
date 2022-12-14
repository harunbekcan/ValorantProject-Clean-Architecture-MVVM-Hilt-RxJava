package com.harunbekcan.valorantproject.data.response.maps

import com.google.gson.annotations.SerializedName

data class MapsResponse(
    @SerializedName("data")
    val mapList: List<MapsResponseItem>,
    @SerializedName("status")
    val status: Int
)