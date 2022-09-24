package com.harunbekcan.valorantproject.data.api

import com.harunbekcan.valorantproject.data.response.AgentResponse
import retrofit2.http.GET

interface ServiceInterface {

    @GET("v1/agents/?isPlayableCharacter=true")
    suspend fun getAgents(): AgentResponse
}