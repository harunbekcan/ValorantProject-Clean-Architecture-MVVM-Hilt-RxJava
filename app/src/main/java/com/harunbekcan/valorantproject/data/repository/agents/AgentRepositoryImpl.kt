package com.harunbekcan.valorantproject.data.repository.agents

import com.harunbekcan.valorantproject.data.api.ServiceInterface
import com.harunbekcan.valorantproject.data.response.agents.AgentsResponse
import io.reactivex.rxjava3.core.Single

class AgentRepositoryImpl(private val serviceInterface: ServiceInterface) : AgentRepository {

    override fun getAgents(): Single<AgentsResponse> {
        return serviceInterface.getAgents()
    }
}