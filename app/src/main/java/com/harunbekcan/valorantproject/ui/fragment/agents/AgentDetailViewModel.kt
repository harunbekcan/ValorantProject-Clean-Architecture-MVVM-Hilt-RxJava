package com.harunbekcan.valorantproject.ui.fragment.agents

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.data.response.agents.AgentDetailResponse
import com.harunbekcan.valorantproject.data.response.agents.AgentsResponse
import com.harunbekcan.valorantproject.data.usecase.agents.AgentDetailUseCase
import com.harunbekcan.valorantproject.ui.mapper.agents.AgentDetailMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgentDetailViewModel @Inject constructor(
    private val agentDetailUseCase: AgentDetailUseCase,
    private val agentDetailMapper: AgentDetailMapper
) : ViewModel() {

    val agentDetailResponseObserve = MutableLiveData<AgentDetailResponse>()
    private val isLoad = MutableLiveData<Boolean>()

    fun agentsRequest() {
        agentDetailUseCase.execute(
            onSuccess = {
                isLoad.value = true
                agentDetailResponseObserve.postValue(it)
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
    fun getAgentDetailItem() = agentDetailMapper.getAgentDetailItem()
    fun mapOnAgentDetailResponse(agentDetailResponse: AgentDetailResponse) = agentDetailMapper.mapOnAgentDetailResponse(agentDetailResponse)
}