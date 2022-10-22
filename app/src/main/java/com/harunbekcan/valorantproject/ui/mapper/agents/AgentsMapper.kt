package com.harunbekcan.valorantproject.ui.mapper.agents

import com.harunbekcan.valorantproject.data.response.agents.AgentsResponse
import com.harunbekcan.valorantproject.data.response.agents.AgentsResponseItem
import com.harunbekcan.valorantproject.data.uimodel.agents.AgentsItem
import javax.inject.Inject

open class AgentsMapper @Inject constructor() {

    var agentsAdapterList = ArrayList<AgentsItem>()

    fun mapOnAgentsResponse(agentsResponse: AgentsResponse){
        agentsAdapterList.clear()
        addAgentsItem(agentsResponse)
    }

    private fun agentsResponseConvertToModel(agentsResponseItem: AgentsResponseItem): AgentsItem {
        return AgentsItem().apply {
            agentsResponseItem.displayIcon.let { displayIcon-> this.displayIcon = displayIcon }
            agentsResponseItem.displayName.let { displayName-> this.displayName = displayName }
            agentsResponseItem.uuid.let { uuid-> this.uuid = uuid }
        }
    }

    private fun addAgentsItem(agentsResponse: AgentsResponse) {
        agentsResponse.agentList.forEach { response ->
            val agentsItem = agentsResponseConvertToModel(response)
            agentsAdapterList.add(agentsItem)
        }
    }
}