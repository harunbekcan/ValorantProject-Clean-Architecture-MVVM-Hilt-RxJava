package com.harunbekcan.valorantproject.ui.mapper.weapons

import com.harunbekcan.valorantproject.data.response.weapons.WeaponDetailResponse
import com.harunbekcan.valorantproject.data.response.weapons.WeaponsResponseItem
import com.harunbekcan.valorantproject.data.uimodel.weapons.WeaponDetailItem
import javax.inject.Inject

open class WeaponDetailMapper @Inject constructor() {

    var weaponDetailItem : WeaponDetailItem?= null

    fun mapOnWeaponDetailResponse(weaponDetailResponse: WeaponDetailResponse) {
        addWeaponDetailItem(weaponDetailResponse)
    }

    private fun weaponDetailResponseConvertToModel(weaponsResponseItem: WeaponsResponseItem): WeaponDetailItem {
        return WeaponDetailItem().apply {
            weaponsResponseItem.displayName.let { displayName -> this.weaponName = displayName }
            weaponsResponseItem.uuid.let { uuid-> this.uuid = uuid }
            weaponsResponseItem.displayIcon.let { uuid-> this.weaponIcon = uuid }
            weaponsResponseItem.shopData.categoryText.let { categoryText-> this.weaponName = categoryText }
        }
    }

    private fun addWeaponDetailItem(weaponDetailResponse: WeaponDetailResponse) {
        weaponDetailResponse.data.let { response ->
            weaponDetailItem = weaponDetailResponseConvertToModel(response)
        }
    }
}