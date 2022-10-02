package com.harunbekcan.valorantproject.data.uimodel.agents

import com.harunbekcan.valorantproject.data.response.agents.Ability
import com.harunbekcan.valorantproject.data.response.agents.Role

data class AgentsItem(
    var abilities: List<Ability>?= arrayListOf(),
    var description: String ?= null,
    var displayIcon: String ?= null,
    var displayName: String ?= null,
    var fullPortraitV2: String ?= null,
    var role: Role?= null,
    var uuid: String ?= null
)