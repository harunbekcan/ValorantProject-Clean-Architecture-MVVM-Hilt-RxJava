package com.harunbekcan.valorantproject.ui.fragment.agents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.data.uimodel.agents.AgentsItem
import com.harunbekcan.valorantproject.data.usecase.agents.AgentsUseCase
import com.harunbekcan.valorantproject.ui.mapper.agents.AgentsMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgentsViewModel @Inject constructor(
    private val agentsUseCase: AgentsUseCase,
    private val agentsMapper: AgentsMapper
) : ViewModel() {

    private val _agentAdapterList = MutableLiveData<ArrayList<AgentsItem>>()
    val agentAdapterList : LiveData<ArrayList<AgentsItem>> = _agentAdapterList

    fun agentsRequest() {
        agentsUseCase.execute(
            onSuccess = {
                agentsMapper.mapOnAgentsResponse(it)
                _agentAdapterList.value = agentsMapper.getAgentsAdapterList()
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}