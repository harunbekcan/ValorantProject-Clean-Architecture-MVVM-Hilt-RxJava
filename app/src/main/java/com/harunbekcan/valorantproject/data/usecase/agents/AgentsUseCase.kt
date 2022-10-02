package com.harunbekcan.valorantproject.data.usecase.agents

import com.harunbekcan.valorantproject.base.BaseUseCase
import com.harunbekcan.valorantproject.data.repository.agents.AgentsRepository
import com.harunbekcan.valorantproject.data.response.agents.AgentsResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class AgentsUseCase @Inject constructor(
    private val agentsRepository: AgentsRepository
) : BaseUseCase<AgentsResponse>() {

    override fun buildUseCaseSingle(): Single<AgentsResponse> {
        return agentsRepository.getAgents()
    }
}