package com.harunbekcan.valorantproject.data.repository.maps

import com.harunbekcan.valorantproject.data.api.ServiceInterface
import com.harunbekcan.valorantproject.data.response.maps.MapDetailResponse
import com.harunbekcan.valorantproject.data.response.maps.MapsResponse
import io.reactivex.rxjava3.core.Single

class MapsRepositoryImpl(private val serviceInterface: ServiceInterface) : MapsRepository {

    override fun getMaps(): Single<MapsResponse> {
        return serviceInterface.getMaps()
    }

    override fun getMapDetail(mapUuid: String): Single<MapDetailResponse> {
        return serviceInterface.getMapDetail(mapUuid)
    }
}