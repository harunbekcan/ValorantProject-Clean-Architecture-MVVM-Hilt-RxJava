package com.harunbekcan.valorantproject.data.api

import com.harunbekcan.valorantproject.data.response.agents.AgentDetailResponse
import com.harunbekcan.valorantproject.data.response.agents.AgentsResponse
import com.harunbekcan.valorantproject.data.response.maps.MapsResponse
import com.harunbekcan.valorantproject.data.response.tiers.TiersResponse
import com.harunbekcan.valorantproject.data.response.weapons.WeaponDetailResponse
import com.harunbekcan.valorantproject.data.response.weapons.WeaponsResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceInterface {

    @GET("agents/?isPlayableCharacter=true")
    fun getAgents(): Single<AgentsResponse>

    @GET("agents/{agentUuid}")
    fun getAgentDetail(@Path("agentUuid") agentUuid: String): Single<AgentDetailResponse>

    @GET("maps")
    fun getMaps(): Single<MapsResponse>

    @GET("weapons")
    fun getWeapons(): Single<WeaponsResponse>

    @GET("weapons/{weaponUuid}")
    fun getWeaponDetail(@Path("weaponUuid") weaponUuid: String): Single<WeaponDetailResponse>

    @GET("competitivetiers")
    fun getTiers(): Single<TiersResponse>

}