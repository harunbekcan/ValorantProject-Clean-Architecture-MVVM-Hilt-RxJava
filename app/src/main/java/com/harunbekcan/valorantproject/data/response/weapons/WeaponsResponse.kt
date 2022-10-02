package com.harunbekcan.valorantproject.data.response.weapons

import com.google.gson.annotations.SerializedName

data class WeaponsResponse(
    @SerializedName("data")
    val weaponList: List<WeaponsResponseItem>,
    @SerializedName("status")
    val status: Int
)