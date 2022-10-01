package com.harunbekcan.valorantproject.ui.mapper.maps

import com.harunbekcan.valorantproject.data.response.maps.MapResponse
import com.harunbekcan.valorantproject.data.response.maps.MapResponseItem
import com.harunbekcan.valorantproject.data.uimodel.maps.MapItem
import javax.inject.Inject

open class MapMapper @Inject constructor() {
    private var mapAdapterList = ArrayList<MapItem>()
    fun getMapAdapterList() = mapAdapterList

    fun mapOnMapResponse(mapResponse: MapResponse){
        mapAdapterList.clear()
        addMapItem(mapResponse)
    }

    private fun mapResponseConvertToModel(mapResponseItem: MapResponseItem): MapItem {
        return MapItem().apply {
            mapResponseItem.splash.let { mapIcon-> this.mapIcon = mapIcon }
            mapResponseItem.displayName.let { displayName-> this.displayName = displayName }
        }
    }

    private fun addMapItem(mapResponse: MapResponse) {
        mapResponse.mapList.forEach { response ->
            val mapItem = mapResponseConvertToModel(response)
            mapAdapterList.add(mapItem)
        }
    }
}