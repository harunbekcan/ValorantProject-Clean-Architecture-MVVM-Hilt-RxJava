package com.harunbekcan.valorantproject.data.repository.agents

import com.harunbekcan.valorantproject.data.response.agents.AgentDetailResponse
import com.harunbekcan.valorantproject.data.response.agents.AgentsResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface AgentsRepository {

    fun getAgents(): Single<AgentsResponse>

    fun getAgentDetail(agentUuid: String): Single<AgentDetailResponse>
}