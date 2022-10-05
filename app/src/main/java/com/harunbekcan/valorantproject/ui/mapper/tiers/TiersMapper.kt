package com.harunbekcan.valorantproject.ui.mapper.tiers

import com.harunbekcan.valorantproject.data.response.tiers.CompetitiveTierResponse
import com.harunbekcan.valorantproject.data.response.tiers.TiersResponse
import com.harunbekcan.valorantproject.data.uimodel.tiers.TiersItem
import javax.inject.Inject

open class TiersMapper @Inject constructor() {

    private var tiersAdapterList = ArrayList<TiersItem>()
    fun getTiersAdapterList() = tiersAdapterList

    fun mapOnTiersResponse(tiersResponse: TiersResponse){
        tiersAdapterList.clear()
        addTiersItem(tiersResponse)
    }

    private fun tiersResponseConvertToModel(competitiveTierResponse: CompetitiveTierResponse): TiersItem {
        return TiersItem().apply {
            competitiveTierResponse.tiers.forEach { item->
                item.tierName.let { tierName-> this.tierName = tierName }
                item.largeIcon.let { tierName-> this.tierIcon = tierName }
            }
        }
    }

    private fun addTiersItem(tiersResponse: TiersResponse) {
        tiersResponse.data.forEach { competitiveTierResponse ->
            competitiveTierResponse.tiers.forEach { item->
                val tiersItem = tiersResponseConvertToModel(competitiveTierResponse)
                tiersAdapterList.add(tiersItem)
            }
        }
    }
}