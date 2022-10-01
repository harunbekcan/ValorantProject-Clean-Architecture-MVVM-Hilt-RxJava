package com.harunbekcan.valorantproject.data.response.maps

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.RawValue

data class MapResponseItem(
    @SerializedName("assetPath")
    val assetPath: String,
    @SerializedName("callouts")
    val callouts: @RawValue List<CallOut>,
    @SerializedName("coordinates")
    val coordinates: String,
    @SerializedName("displayIcon")
    val displayIcon: String?,
    @SerializedName("displayName")
    val displayName: String?,
    @SerializedName("listViewIcon")
    val listViewIcon: String,
    @SerializedName("mapUrl")
    val mapUrl: String,
    @SerializedName("splash")
    val splash: String,
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("xMultiplier")
    val xMultiplier: Double,
    @SerializedName("xScalarToAdd")
    val xScalarToAdd: Double,
    @SerializedName("yMultiplier")
    val yMultiplier: Double,
    @SerializedName("yScalarToAdd")
    val yScalarToAdd: Double
)

data class CallOut(
    @SerializedName("location")
    val location: Location,
    @SerializedName("regionName")
    val regionName: String,
    @SerializedName("superRegionName")
    val superRegionName: String
)

data class Location(
    @SerializedName("x")
    val x: Double,
    @SerializedName("y")
    val y: Double
)