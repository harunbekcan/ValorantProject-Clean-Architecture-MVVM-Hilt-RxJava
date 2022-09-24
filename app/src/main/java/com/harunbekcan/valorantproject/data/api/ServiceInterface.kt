package com.harunbekcan.valorantproject.data.api

import com.harunbekcan.valorantproject.data.response.AgentResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ServiceInterface {

    @GET("agents/?isPlayableCharacter=true")
    suspend fun getAgents(): Single<AgentResponse>
}