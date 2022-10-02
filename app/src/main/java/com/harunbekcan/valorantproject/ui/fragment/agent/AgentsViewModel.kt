package com.harunbekcan.valorantproject.ui.fragment.agent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.data.response.agents.AgentsResponse
import com.harunbekcan.valorantproject.data.usecase.agents.AgentsUseCase
import com.harunbekcan.valorantproject.ui.mapper.agents.AgentsMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgentsViewModel @Inject constructor(private val agentsUseCase: AgentsUseCase, private val agentsMapper: AgentsMapper) : ViewModel() {

    val agentsResponseObserve = MutableLiveData<AgentsResponse>()
    private val isLoad = MutableLiveData<Boolean>()

    fun agentsRequest() {
        agentsUseCase.execute(
            onSuccess = {
                isLoad.value = true
                agentsResponseObserve.postValue(it)
            },
            onError = {
                it.printStackTrace()
            }
        )
    }

    fun getAgentsAdapterList() = agentsMapper.getAgentsAdapterList()

    fun mapOnAgentsResponse(agentsResponse: AgentsResponse) = agentsMapper.mapOnAgentsResponse(agentsResponse)
}