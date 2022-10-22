package com.harunbekcan.valorantproject.ui.mapper.maps

import com.harunbekcan.valorantproject.data.response.maps.MapDetailResponse
import com.harunbekcan.valorantproject.data.response.maps.MapsResponseItem
import com.harunbekcan.valorantproject.data.uimodel.maps.MapDetailItem
import javax.inject.Inject

open class MapDetailMapper @Inject constructor() {

    var mapDetailItem: MapDetailItem? = null

    fun mapOnMapDetailResponse(mapDetailResponse: MapDetailResponse) {
        addMapDetailItem(mapDetailResponse)
    }

    private fun mapDetailResponseConvertToModel(mapDetailResponseItem: MapsResponseItem): MapDetailItem {
        return MapDetailItem().apply {
            mapDetailResponseItem.displayIcon.let { mapIcon -> this.mapIcon = mapIcon }
            mapDetailResponseItem.displayName.let { mapName -> this.mapName = mapName }
            mapDetailResponseItem.coordinates.let { mapCoordinate -> this.mapCoordinate = mapCoordinate }
        }
    }

    private fun addMapDetailItem(mapDetailResponse: MapDetailResponse) {
        mapDetailResponse.data.let { response ->
            mapDetailItem = mapDetailResponseConvertToModel(response)
        }
    }
}