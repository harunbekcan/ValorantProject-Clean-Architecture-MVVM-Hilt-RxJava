package com.harunbekcan.valorantproject.data.response.weapons

import com.google.gson.annotations.SerializedName

data class WeaponDetailResponse(
    @SerializedName("data")
    val data: WeaponsResponseItem,
    @SerializedName("status")
    val status: Int
)