package com.harunbekcan.valorantproject.ui.mapper.maps

import com.harunbekcan.valorantproject.data.response.maps.MapsResponse
import com.harunbekcan.valorantproject.data.response.maps.MapsResponseItem
import com.harunbekcan.valorantproject.data.uimodel.maps.MapsItem
import javax.inject.Inject

open class MapsMapper @Inject constructor() {

    var mapsAdapterList = ArrayList<MapsItem>()

    fun mapOnMapsResponse(mapsResponse: MapsResponse){
        mapsAdapterList.clear()
        addMapsItem(mapsResponse)
    }

    private fun mapsResponseConvertToModel(mapsResponseItem: MapsResponseItem): MapsItem {
        return MapsItem().apply {
            mapsResponseItem.splash.let { mapIcon-> this.mapIcon = mapIcon }
            mapsResponseItem.displayName.let { displayName-> this.displayName = displayName }
        }
    }

    private fun addMapsItem(mapsResponse: MapsResponse) {
        mapsResponse.mapList.forEach { response ->
            val mapsItem = mapsResponseConvertToModel(response)
            mapsAdapterList.add(mapsItem)
        }
    }
}