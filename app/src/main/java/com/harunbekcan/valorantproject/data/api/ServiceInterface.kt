package com.harunbekcan.valorantproject.data.api

import com.harunbekcan.valorantproject.data.response.agents.AgentDetailResponse
import com.harunbekcan.valorantproject.data.response.agents.AgentsResponse
import com.harunbekcan.valorantproject.data.response.maps.MapsResponse
import com.harunbekcan.valorantproject.data.response.tiers.TiersResponse
import com.harunbekcan.valorantproject.data.response.weapons.WeaponsResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceInterface {

    @GET("agents/?isPlayableCharacter=true")
    fun getAgents(): Single<AgentsResponse>

    @GET("agents/{agentUuid}")
    suspend fun getAgentDetail(@Path("agentUuid") agentUuid: String): AgentDetailResponse

    @GET("maps")
    fun getMaps(): Single<MapsResponse>

    @GET("weapons")
    fun getWeapons(): Single<WeaponsResponse>

    @GET("competitivetiers")
    fun getTiers(): Single<TiersResponse>

}