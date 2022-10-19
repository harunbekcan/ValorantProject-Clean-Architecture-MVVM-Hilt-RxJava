package com.harunbekcan.valorantproject.data.usecase.weapons

import com.harunbekcan.valorantproject.base.BaseUseCase
import com.harunbekcan.valorantproject.data.repository.weapons.WeaponsRepository
import com.harunbekcan.valorantproject.data.response.weapons.WeaponDetailResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class WeaponDetailUseCase @Inject constructor(
    private val weaponsRepository: WeaponsRepository
) : BaseUseCase<WeaponDetailResponse>() {

    private lateinit var id : String

    fun weaponUuid(weaponUuid: String) {
        id = weaponUuid
    }
    override fun buildUseCaseSingle(): Single<WeaponDetailResponse> {
        return weaponsRepository.getWeaponDetail(id)
    }
}