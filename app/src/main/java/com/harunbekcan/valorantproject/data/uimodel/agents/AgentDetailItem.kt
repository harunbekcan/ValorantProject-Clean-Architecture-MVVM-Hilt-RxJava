package com.harunbekcan.valorantproject.data.uimodel.agents

data class AgentDetailItem (
    var agentDescription : String ?= "",
    var agentIcon : String ?= "",
    var agentName : String ?= "",
    var bustPortrait : String ?= "",
    var roleName : String ?= "",
    var uuid : String ?= "",
    var abilities : List<AbilityItem> ?= arrayListOf(),
)


data class AbilityItem(
    var description: String? = "",
    var displayIcon: String? = "",
    var displayName: String? = "",
)