package com.harunbekcan.valorantproject.data.response.weapons

import com.google.gson.annotations.SerializedName

data class WeaponStats(
    @SerializedName("damageRanges")
    val damageRanges: List<DamageRange>,
)

data class DamageRange(
    @SerializedName("bodyDamage")
    val bodyDamage: Int,
    @SerializedName("headDamage")
    val headDamage: Double,
    @SerializedName("legDamage")
    val legDamage: Double,
    @SerializedName("rangeEndMeters")
    val rangeEndMeters: Int,
    @SerializedName("rangeStartMeters")
    val rangeStartMeters: Int
)