package com.harunbekcan.valorantproject.data.repository.weapons

import com.harunbekcan.valorantproject.data.response.weapons.WeaponsResponse
import io.reactivex.rxjava3.core.Single

interface WeaponsRepository {

    fun getWeapons():Single<WeaponsResponse>
}