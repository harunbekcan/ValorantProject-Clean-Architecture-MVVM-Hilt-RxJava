package com.harunbekcan.valorantproject.ui.mapper.maps

import com.harunbekcan.valorantproject.data.response.maps.MapsResponse
import com.harunbekcan.valorantproject.data.response.maps.MapsResponseItem
import com.harunbekcan.valorantproject.data.uimodel.maps.MapItem
import javax.inject.Inject

open class MapMapper @Inject constructor() {
    private var mapAdapterList = ArrayList<MapItem>()
    fun getMapAdapterList() = mapAdapterList

    fun mapOnMapsResponse(mapsResponse: MapsResponse){
        mapAdapterList.clear()
        addMapItem(mapsResponse)
    }

    private fun mapsResponseConvertToModel(mapsResponseItem: MapsResponseItem): MapItem {
        return MapItem().apply {
            mapsResponseItem.splash.let { mapIcon-> this.mapIcon = mapIcon }
            mapsResponseItem.displayName.let { displayName-> this.displayName = displayName }
        }
    }

    private fun addMapItem(mapsResponse: MapsResponse) {
        mapsResponse.mapList.forEach { response ->
            val mapItem = mapsResponseConvertToModel(response)
            mapAdapterList.add(mapItem)
        }
    }
}