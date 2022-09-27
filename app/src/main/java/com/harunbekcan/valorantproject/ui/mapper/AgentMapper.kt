package com.harunbekcan.valorantproject.ui.mapper

import com.harunbekcan.valorantproject.data.response.AgentResponse
import com.harunbekcan.valorantproject.data.response.AgentResponseItem
import com.harunbekcan.valorantproject.data.uimodel.AgentItem

open class AgentMapper {

    private var agentAdapterList = arrayListOf<AgentItem>()
    fun getAgentAdapterList() = agentAdapterList

    fun mapOnAgentResponse(agentResponse: AgentResponse){
        agentAdapterList.clear()
        addAgentItem(agentResponse)
    }

    private fun agentResponseConvertToModel(agentResponseItem: AgentResponseItem): AgentItem {
        return AgentItem().apply {
            agentResponseItem.abilities?.let { abilities-> this.abilities = abilities }
            agentResponseItem.description?.let { description-> this.description = description }
            agentResponseItem.displayIcon?.let { displayIcon-> this.displayIcon = displayIcon }
            agentResponseItem.displayName?.let { displayName-> this.displayName = displayName }
            agentResponseItem.fullPortraitV2?.let { fullPortraitV2-> this.fullPortraitV2 = fullPortraitV2 }
            agentResponseItem.role?.let { role-> this.role = role }
            agentResponseItem.uuid?.let { uuid-> this.uuid = uuid }
        }
    }

    private fun addAgentItem(agentResponse: AgentResponse) {
        agentResponse.agentList.forEach { response ->
            val agentItem = agentResponseConvertToModel(response)
            agentAdapterList.add(agentItem)
        }
    }
}