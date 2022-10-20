package com.harunbekcan.valorantproject.ui.mapper.weapons

import com.harunbekcan.valorantproject.data.response.weapons.WeaponDetailResponse
import com.harunbekcan.valorantproject.data.response.weapons.WeaponsResponseItem
import com.harunbekcan.valorantproject.data.uimodel.weapons.DamageRangeItem
import com.harunbekcan.valorantproject.data.uimodel.weapons.SkinItem
import com.harunbekcan.valorantproject.data.uimodel.weapons.WeaponDetailItem
import com.harunbekcan.valorantproject.utils.Constants.RANDOM_FAVORITE_SKIN
import com.harunbekcan.valorantproject.utils.Constants.STANDARD
import javax.inject.Inject

open class WeaponDetailMapper @Inject constructor() {

    var weaponDetailItem: WeaponDetailItem? = null

    fun mapOnWeaponDetailResponse(weaponDetailResponse: WeaponDetailResponse) {
        addWeaponDetailItem(weaponDetailResponse)
    }

    private fun weaponDetailResponseConvertToModel(weaponsResponseItem: WeaponsResponseItem): WeaponDetailItem {
        return WeaponDetailItem().apply {
            weaponsResponseItem.displayName.let { displayName -> this.weaponName = displayName }
            weaponsResponseItem.uuid.let { uuid -> this.uuid = uuid }
            weaponsResponseItem.displayIcon.let { uuid -> this.weaponIcon = uuid }
            weaponsResponseItem.shopData.categoryText.let { categoryText -> this.weaponCategory = categoryText }
            damageRangeList = damageListConvertToModel(weaponsResponseItem)
            skinList = skinListConvertToModel(weaponsResponseItem)
        }
    }

    private fun addWeaponDetailItem(weaponDetailResponse: WeaponDetailResponse) {
        weaponDetailResponse.data.let { response ->
            weaponDetailItem = weaponDetailResponseConvertToModel(response)
        }
    }

    private fun damageListConvertToModel(weaponsResponseItem: WeaponsResponseItem): ArrayList<DamageRangeItem> {
        val damageList = arrayListOf<DamageRangeItem>()
        weaponsResponseItem.weaponStats.damageRanges.forEach { damageRange ->
            damageList.add(
                DamageRangeItem(
                    damageRange.headDamage,
                    damageRange.bodyDamage,
                    damageRange.legDamage,
                )
            )
        }
        return damageList
    }

    private fun skinListConvertToModel(weaponsResponseItem: WeaponsResponseItem): ArrayList<SkinItem> {
        val skinList = arrayListOf<SkinItem>()
        weaponsResponseItem.skins.forEach { item ->
            if (item.displayIcon.isNullOrEmpty().not() && item.displayName.contains(STANDARD).not() && item.displayName.contains(RANDOM_FAVORITE_SKIN).not()) {
                skinList.add(
                    SkinItem(
                        item.displayIcon,
                        item.displayName
                    )
                )
            }
        }
        return skinList
    }
}