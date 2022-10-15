package com.harunbekcan.valorantproject.data.repository.agents

import com.harunbekcan.valorantproject.data.api.ServiceInterface
import com.harunbekcan.valorantproject.data.response.agents.AgentDetailResponse
import com.harunbekcan.valorantproject.data.response.agents.AgentsResponse
import io.reactivex.rxjava3.core.Single

class AgentsRepositoryImpl(private val serviceInterface: ServiceInterface) : AgentsRepository {

    override fun getAgents(): Single<AgentsResponse> {
        return serviceInterface.getAgents()
    }

    override fun getAgentDetail(agentUuid: String): Single<AgentDetailResponse> {
        return serviceInterface.getAgentDetail(agentUuid)
    }
}