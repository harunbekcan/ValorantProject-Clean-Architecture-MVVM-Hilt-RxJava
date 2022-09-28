package com.harunbekcan.valorantproject.data.repository

import com.harunbekcan.valorantproject.data.api.ServiceInterface
import com.harunbekcan.valorantproject.data.response.AgentResponse
import io.reactivex.rxjava3.core.Single

class AgentRepositoryImpl(private val serviceInterface: ServiceInterface) : AgentRepository {

    override fun getAgents(): Single<AgentResponse> {
        return serviceInterface.getAgents()
    }
}