package com.harunbekcan.valorantproject.data.usecase

import com.harunbekcan.valorantproject.base.BaseUseCase
import com.harunbekcan.valorantproject.data.repository.AgentRepository
import com.harunbekcan.valorantproject.data.response.AgentResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class AgentUseCase @Inject constructor(
    private val agentRepository: AgentRepository
) : BaseUseCase<AgentResponse>() {

    override fun buildUseCaseSingle(): Single<AgentResponse> {
        return agentRepository.getAgents()
    }
}