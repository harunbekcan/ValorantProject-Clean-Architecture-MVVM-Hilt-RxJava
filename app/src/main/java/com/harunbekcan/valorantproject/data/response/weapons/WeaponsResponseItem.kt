package com.harunbekcan.valorantproject.data.response.weapons

import com.google.gson.annotations.SerializedName

data class WeaponsResponseItem(
    @SerializedName("assetPath")
    val assetPath: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("defaultSkinUuid")
    val defaultSkinUuid: String,
    @SerializedName("displayIcon")
    val displayIcon: String,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("killStreamIcon")
    val killStreamIcon: String,
    @SerializedName("skins")
    var skins: List<Skin>,
    @SerializedName("shopData")
    val shopData: ShopData?,
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("weaponStats")
    val weaponStats: WeaponStats?
)