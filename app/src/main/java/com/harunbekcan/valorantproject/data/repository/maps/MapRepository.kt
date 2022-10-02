package com.harunbekcan.valorantproject.data.repository.maps

import com.harunbekcan.valorantproject.data.response.maps.MapsResponse
import io.reactivex.rxjava3.core.Single

interface MapRepository {

    fun getMaps(): Single<MapsResponse>

}