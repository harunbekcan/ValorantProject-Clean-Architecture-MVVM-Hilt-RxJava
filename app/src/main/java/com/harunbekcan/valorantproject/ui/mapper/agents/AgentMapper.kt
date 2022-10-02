package com.harunbekcan.valorantproject.ui.mapper.agents

import com.harunbekcan.valorantproject.data.response.agents.AgentsResponse
import com.harunbekcan.valorantproject.data.response.agents.AgentsResponseItem
import com.harunbekcan.valorantproject.data.uimodel.agents.AgentItem
import javax.inject.Inject

open class AgentMapper @Inject constructor() {

    private var agentAdapterList = ArrayList<AgentItem>()
    fun getAgentAdapterList() = agentAdapterList

    fun mapOnAgentsResponse(agentsResponse: AgentsResponse){
        agentAdapterList.clear()
        addAgentItem(agentsResponse)
    }

    private fun agentsResponseConvertToModel(agentsResponseItem: AgentsResponseItem): AgentItem {
        return AgentItem().apply {
            agentsResponseItem.abilities.let { abilities-> this.abilities = abilities }
            agentsResponseItem.description.let { description-> this.description = description }
            agentsResponseItem.displayIcon.let { displayIcon-> this.displayIcon = displayIcon }
            agentsResponseItem.displayName.let { displayName-> this.displayName = displayName }
            agentsResponseItem.fullPortraitV2.let { fullPortraitV2-> this.fullPortraitV2 = fullPortraitV2 }
            agentsResponseItem.role.let { role-> this.role = role }
            agentsResponseItem.uuid.let { uuid-> this.uuid = uuid }
        }
    }

    private fun addAgentItem(agentsResponse: AgentsResponse) {
        agentsResponse.agentList.forEach { response ->
            val agentItem = agentsResponseConvertToModel(response)
            agentAdapterList.add(agentItem)
        }
    }
}