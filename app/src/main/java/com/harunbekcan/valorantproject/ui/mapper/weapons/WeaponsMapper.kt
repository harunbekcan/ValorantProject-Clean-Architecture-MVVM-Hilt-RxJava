package com.harunbekcan.valorantproject.ui.mapper.weapons

import com.harunbekcan.valorantproject.data.response.weapons.WeaponsResponse
import com.harunbekcan.valorantproject.data.response.weapons.WeaponsResponseItem
import com.harunbekcan.valorantproject.data.uimodel.weapons.WeaponsItem
import javax.inject.Inject

open class WeaponsMapper @Inject constructor() {

    var weaponsAdapterList = ArrayList<WeaponsItem>()

    fun mapOnWeaponsResponse(weaponsResponse: WeaponsResponse){
        weaponsAdapterList.clear()
        addWeaponsItem(weaponsResponse)
    }

    private fun weaponsResponseConvertToModel(weaponsResponseItem: WeaponsResponseItem): WeaponsItem {
        return WeaponsItem().apply {
            weaponsResponseItem.displayIcon.let { displayIcon-> this.displayIcon = displayIcon }
            weaponsResponseItem.displayName.let { displayName-> this.displayName = displayName }
            weaponsResponseItem.uuid.let { uuid-> this.uuid = uuid }
        }
    }

    private fun addWeaponsItem(weaponsResponse: WeaponsResponse) {
        weaponsResponse.weaponList.forEach { response ->
            val weaponItem = weaponsResponseConvertToModel(response)
            weaponsAdapterList.add(weaponItem)
        }
    }
}