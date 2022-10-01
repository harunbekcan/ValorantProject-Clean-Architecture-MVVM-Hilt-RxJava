package com.harunbekcan.valorantproject.data.uimodel

import com.harunbekcan.valorantproject.data.response.agents.Ability
import com.harunbekcan.valorantproject.data.response.agents.Role

data class AgentItem(
    var abilities: List<Ability> ?= arrayListOf(),
    var description: String ?= "",
    var displayIcon: String ?= "",
    var displayName: String ?= "",
    var fullPortraitV2: String ?= "",
    var role: Role?= null,
    var uuid: String ?= ""
)