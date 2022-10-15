package com.harunbekcan.valorantproject.data.usecase.agents

import com.harunbekcan.valorantproject.base.BaseUseCase
import com.harunbekcan.valorantproject.data.repository.agents.AgentsRepository
import com.harunbekcan.valorantproject.data.response.agents.AgentDetailResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class AgentDetailUseCase @Inject constructor(
    private val agentsRepository: AgentsRepository,
    private val uuid: String
) : BaseUseCase<AgentDetailResponse>() {

    override fun buildUseCaseSingle(): Single<AgentDetailResponse> {
        return agentsRepository.getAgentDetail(uuid)
    }
}