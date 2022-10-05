package com.harunbekcan.valorantproject.ui.mapper.tiers

import com.harunbekcan.valorantproject.data.response.tiers.CompetitiveTierResponseItem
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

    private fun tiersResponseConvertToModel(competitiveTierResponseItem: CompetitiveTierResponseItem): TiersItem {
        return TiersItem().apply {
            competitiveTierResponseItem.tierName.let { tierName-> this.tierName = tierName }
            competitiveTierResponseItem.largeIcon.let { tierName-> this.tierIcon = tierName }
        }
    }

    private fun addTiersItem(tiersResponse: TiersResponse) {
        tiersResponse.data.last().let{ competitiveTierResponse ->
            competitiveTierResponse.tiers.forEach { item->
                val tiersItem = tiersResponseConvertToModel(item)
                item.rankTriangleUpIcon?.let {
                    tiersAdapterList.add(tiersItem)
                }
            }
        }
    }
}