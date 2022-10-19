package com.harunbekcan.valorantproject.ui.mapper.weapons

import com.harunbekcan.valorantproject.data.response.weapons.WeaponDetailResponse
import com.harunbekcan.valorantproject.data.response.weapons.WeaponsResponseItem
import com.harunbekcan.valorantproject.data.uimodel.weapons.DamageRangeItem
import com.harunbekcan.valorantproject.data.uimodel.weapons.WeaponDetailItem
import javax.inject.Inject

open class WeaponDetailMapper @Inject constructor() {

    var weaponDetailItem : WeaponDetailItem?= null

    fun mapOnWeaponDetailResponse(weaponDetailResponse: WeaponDetailResponse) {
        addWeaponDetailItem(weaponDetailResponse)
    }

    private fun weaponDetailResponseConvertToModel(weaponsResponseItem: WeaponsResponseItem): WeaponDetailItem {
        val damageList = arrayListOf<DamageRangeItem>()
        weaponsResponseItem.weaponStats.damageRanges.forEach {damageRange ->
            damageList.add(
                DamageRangeItem(
                    damageRange.headDamage,
                    damageRange.bodyDamage,
                    damageRange.legDamage,
                )
            )
        }
        return WeaponDetailItem().apply {
            weaponsResponseItem.displayName.let { displayName -> this.weaponName = displayName }
            weaponsResponseItem.uuid.let { uuid-> this.uuid = uuid }
            weaponsResponseItem.displayIcon.let { uuid-> this.weaponIcon = uuid }
            weaponsResponseItem.shopData.categoryText.let { categoryText-> this.weaponCategory = categoryText }
            damageRangeList = damageList
        }
    }

    private fun addWeaponDetailItem(weaponDetailResponse: WeaponDetailResponse) {
        weaponDetailResponse.data.let { response ->
            weaponDetailItem = weaponDetailResponseConvertToModel(response)
        }
    }
}