package com.harunbekcan.valorantproject.ui.fragment.agent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.data.response.AgentResponse
import com.harunbekcan.valorantproject.data.usecase.AgentUseCase
import com.harunbekcan.valorantproject.ui.mapper.AgentMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgentsViewModel @Inject constructor(
    private val agentUseCase: AgentUseCase,
    private val agentMapper: AgentMapper
) : ViewModel() {

    val agentResponseObserve = MutableLiveData<AgentResponse>()
    private val isLoad = MutableLiveData<Boolean>()

    fun agentRequest() {
        agentUseCase.execute(
            onSuccess = {
                isLoad.value = true
                agentResponseObserve.postValue(it)
            },
            onError = {
                it.printStackTrace()
            }
        )
    }

    fun getAgentAdapterList() = agentMapper.getAgentAdapterList()

    fun mapOnAgentResponse(agentResponse: AgentResponse) = agentMapper.mapOnAgentResponse(agentResponse)
}