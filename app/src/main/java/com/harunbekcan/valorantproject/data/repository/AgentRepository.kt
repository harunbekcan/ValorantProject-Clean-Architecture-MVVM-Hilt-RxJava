package com.harunbekcan.valorantproject.data.repository

import com.harunbekcan.valorantproject.data.response.AgentResponse
import io.reactivex.rxjava3.core.Single

interface AgentRepository {

    fun getAgents(): Single<AgentResponse>

}