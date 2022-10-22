package com.harunbekcan.valorantproject.ui.mapper.agents

import com.harunbekcan.valorantproject.data.response.agents.AgentDetailResponse
import com.harunbekcan.valorantproject.data.response.agents.AgentsResponseItem
import com.harunbekcan.valorantproject.data.uimodel.agents.AbilityItem
import com.harunbekcan.valorantproject.data.uimodel.agents.AgentDetailItem
import javax.inject.Inject

open class AgentDetailMapper @Inject constructor() {

    var agentDetailItem: AgentDetailItem? = null

    fun mapOnAgentDetailResponse(agentDetailResponse: AgentDetailResponse) {
        addAgentDetailItem(agentDetailResponse)
    }

    private fun agentDetailResponseConvertToModel(agentDetailResponseItem: AgentsResponseItem): AgentDetailItem {
        return AgentDetailItem().apply {
            agentDetailResponseItem.description.let { description -> this.agentDescription = description }
            agentDetailResponseItem.displayName.let { displayName -> this.agentName = displayName }
            agentDetailResponseItem.bustPortrait.let { agentIcon -> this.agentIcon = agentIcon }
            agentDetailResponseItem.role?.displayName?.let { roleName -> this.roleName = roleName }
            agentDetailResponseItem.uuid?.let { uuid -> this.uuid = uuid }
            abilities = abilityListConvertToModel(agentDetailResponseItem)
        }
    }

    private fun addAgentDetailItem(agentDetailResponse: AgentDetailResponse) {
        agentDetailResponse.data.let { response ->
            agentDetailItem = agentDetailResponseConvertToModel(response)
        }
    }

    private fun abilityListConvertToModel(agentDetailResponseItem: AgentsResponseItem): ArrayList<AbilityItem> {
        val abilityList = arrayListOf<AbilityItem>()
        agentDetailResponseItem.abilities?.forEach { ability ->
            abilityList.add(
                AbilityItem(
                    ability.description,
                    ability.displayIcon,
                    ability.displayName,
                )
            )
        }
        return abilityList
    }
}