package com.harunbekcan.valorantproject.data.response.weapons

import com.google.gson.annotations.SerializedName

data class Skin(
    @SerializedName("assetPath")
    val assetPath: String,
    @SerializedName("contentTierUuid")
    val contentTierUuid: String,
    @SerializedName("displayIcon")
    val displayIcon: String?,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("themeUuid")
    val themeUuid: String,
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("wallpaper")
    val wallpaper: Any
)