package com.harunbekcan.valorantproject.data.repository.maps

import com.harunbekcan.valorantproject.data.response.agents.AgentDetailResponse
import com.harunbekcan.valorantproject.data.response.maps.MapDetailResponse
import com.harunbekcan.valorantproject.data.response.maps.MapsResponse
import io.reactivex.rxjava3.core.Single

interface MapsRepository {

    fun getMaps(): Single<MapsResponse>

    fun getMapDetail(mapUuid: String): Single<MapDetailResponse>
}