package com.harunbekcan.valorantproject.data.usecase.maps

import com.harunbekcan.valorantproject.base.BaseUseCase
import com.harunbekcan.valorantproject.data.repository.maps.MapsRepository
import com.harunbekcan.valorantproject.data.response.maps.MapDetailResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MapDetailUseCase @Inject constructor(
    private val mapsRepository: MapsRepository
) : BaseUseCase<MapDetailResponse>() {

    private lateinit var id : String

    fun mapUuid(mapUuid: String) {
        id = mapUuid
    }

    override fun buildUseCaseSingle(): Single<MapDetailResponse> {
        return mapsRepository.getMapDetail(id)
    }
}