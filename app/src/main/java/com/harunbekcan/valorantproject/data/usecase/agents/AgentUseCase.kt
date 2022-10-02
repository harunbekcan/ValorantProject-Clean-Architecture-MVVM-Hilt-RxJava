package com.harunbekcan.valorantproject.data.usecase.agents

import com.harunbekcan.valorantproject.base.BaseUseCase
import com.harunbekcan.valorantproject.data.repository.agents.AgentRepository
import com.harunbekcan.valorantproject.data.response.agents.AgentsResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class AgentUseCase @Inject constructor(
    private val agentRepository: AgentRepository
) : BaseUseCase<AgentsResponse>() {

    override fun buildUseCaseSingle(): Single<AgentsResponse> {
        return agentRepository.getAgents()
    }
}