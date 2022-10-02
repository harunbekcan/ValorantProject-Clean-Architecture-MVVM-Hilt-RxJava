package com.harunbekcan.valorantproject.ui.fragment.agent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.data.response.agents.AgentsResponse
import com.harunbekcan.valorantproject.data.usecase.agents.AgentUseCase
import com.harunbekcan.valorantproject.ui.mapper.agents.AgentMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgentsViewModel @Inject constructor(private val agentUseCase: AgentUseCase, private val agentMapper: AgentMapper) : ViewModel() {

    val agentsResponseObserve = MutableLiveData<AgentsResponse>()
    private val isLoad = MutableLiveData<Boolean>()

    fun agentRequest() {
        agentUseCase.execute(
            onSuccess = {
                isLoad.value = true
                agentsResponseObserve.postValue(it)
            },
            onError = {
                it.printStackTrace()
            }
        )
    }

    fun getAgentAdapterList() = agentMapper.getAgentAdapterList()

    fun mapOnAgentsResponse(agentsResponse: AgentsResponse) = agentMapper.mapOnAgentsResponse(agentsResponse)
}