package com.harunbekcan.valorantproject.data.usecase.weapons

import com.harunbekcan.valorantproject.base.BaseUseCase
import com.harunbekcan.valorantproject.data.repository.weapons.WeaponsRepository
import com.harunbekcan.valorantproject.data.response.weapons.WeaponsResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class WeaponsUseCase @Inject constructor(
    private val weaponsRepository: WeaponsRepository
) : BaseUseCase<WeaponsResponse>() {

    override fun buildUseCaseSingle(): Single<WeaponsResponse> {
        return weaponsRepository.getWeapons()
    }
}