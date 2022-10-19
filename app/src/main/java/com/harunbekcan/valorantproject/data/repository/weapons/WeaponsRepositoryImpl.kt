package com.harunbekcan.valorantproject.data.repository.weapons

import com.harunbekcan.valorantproject.data.api.ServiceInterface
import com.harunbekcan.valorantproject.data.response.weapons.WeaponDetailResponse
import com.harunbekcan.valorantproject.data.response.weapons.WeaponsResponse
import io.reactivex.rxjava3.core.Single

class WeaponsRepositoryImpl(private val serviceInterface: ServiceInterface) : WeaponsRepository {

    override fun getWeapons(): Single<WeaponsResponse> {
        return serviceInterface.getWeapons()
    }

    override fun getWeaponDetail(weaponUuid: String): Single<WeaponDetailResponse> {
        return serviceInterface.getWeaponDetail(weaponUuid)
    }
}