package com.harunbekcan.valorantproject.data.usecase.maps

import com.harunbekcan.valorantproject.base.BaseUseCase
import com.harunbekcan.valorantproject.data.repository.maps.MapRepository
import com.harunbekcan.valorantproject.data.response.maps.MapResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MapUseCase @Inject constructor(
    private val mapRepository: MapRepository
) : BaseUseCase<MapResponse>() {

    override fun buildUseCaseSingle(): Single<MapResponse> {
        return mapRepository.getMaps()
    }
}