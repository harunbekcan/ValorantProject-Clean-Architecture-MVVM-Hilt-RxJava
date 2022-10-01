package com.harunbekcan.valorantproject.data.api

import com.harunbekcan.valorantproject.data.response.agents.AgentResponse
import com.harunbekcan.valorantproject.data.response.maps.MapResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ServiceInterface {

    @GET("agents/?isPlayableCharacter=true")
    fun getAgents(): Single<AgentResponse>

    @GET("maps")
    fun getMaps(): Single<MapResponse>
}