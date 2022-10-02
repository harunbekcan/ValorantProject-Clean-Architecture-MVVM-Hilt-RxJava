package com.harunbekcan.valorantproject.data.api

import com.harunbekcan.valorantproject.data.response.agents.AgentsResponse
import com.harunbekcan.valorantproject.data.response.maps.MapsResponse
import com.harunbekcan.valorantproject.data.response.weapons.WeaponsResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ServiceInterface {

    @GET("agents/?isPlayableCharacter=true")
    fun getAgents(): Single<AgentsResponse>

    @GET("maps")
    fun getMaps(): Single<MapsResponse>

    @GET("weapons")
    suspend fun getWeapons(): WeaponsResponse

}