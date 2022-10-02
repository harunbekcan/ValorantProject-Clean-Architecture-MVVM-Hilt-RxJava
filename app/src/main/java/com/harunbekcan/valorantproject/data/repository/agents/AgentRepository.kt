package com.harunbekcan.valorantproject.data.repository.agents

import com.harunbekcan.valorantproject.data.response.agents.AgentsResponse
import io.reactivex.rxjava3.core.Single

interface AgentRepository {

    fun getAgents(): Single<AgentsResponse>
}