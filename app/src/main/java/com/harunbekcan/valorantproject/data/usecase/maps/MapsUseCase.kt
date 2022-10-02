package com.harunbekcan.valorantproject.data.usecase.maps

import com.harunbekcan.valorantproject.base.BaseUseCase
import com.harunbekcan.valorantproject.data.repository.maps.MapsRepository
import com.harunbekcan.valorantproject.data.response.maps.MapsResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MapsUseCase @Inject constructor(
    private val mapsRepository: MapsRepository
) : BaseUseCase<MapsResponse>() {

    override fun buildUseCaseSingle(): Single<MapsResponse> {
        return mapsRepository.getMaps()
    }
}