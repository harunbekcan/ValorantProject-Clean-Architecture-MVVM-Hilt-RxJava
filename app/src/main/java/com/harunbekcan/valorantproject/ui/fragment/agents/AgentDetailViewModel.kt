package com.harunbekcan.valorantproject.ui.fragment.agents

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

    val agentDetailItemObserve = MutableLiveData<AgentDetailItem>()

    fun agentDetailRequest(uuid:String) {
        agentDetailUseCase.agentUuid(uuid)
        agentDetailUseCase.execute(
            onSuccess = {
                agentDetailMapper.mapOnAgentDetailResponse(it)
                agentDetailItemObserve.postValue(agentDetailMapper.agentDetailItem)
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}