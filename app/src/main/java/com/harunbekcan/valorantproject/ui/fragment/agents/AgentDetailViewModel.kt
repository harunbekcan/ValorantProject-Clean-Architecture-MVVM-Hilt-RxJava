package com.harunbekcan.valorantproject.ui.fragment.agents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.data.uimodel.agents.AgentDetailItem
import com.harunbekcan.valorantproject.data.usecase.agents.AgentDetailUseCase
import com.harunbekcan.valorantproject.ui.mapper.agents.AgentDetailMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgentDetailViewModel @Inject constructor(
    private val agentDetailUseCase: AgentDetailUseCase,
    private val agentDetailMapper: AgentDetailMapper
) : ViewModel() {

    private val _agentDetailItem = MutableLiveData<AgentDetailItem>()
    val agentDetailItem : LiveData<AgentDetailItem> = _agentDetailItem

    fun agentDetailRequest(uuid:String) {
        agentDetailUseCase.agentUuid(uuid)
        agentDetailUseCase.execute(
            onSuccess = {
                agentDetailMapper.mapOnAgentDetailResponse(it)
                _agentDetailItem.value = agentDetailMapper.agentDetailItem
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}