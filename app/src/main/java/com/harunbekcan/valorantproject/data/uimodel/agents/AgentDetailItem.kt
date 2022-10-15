package com.harunbekcan.valorantproject.data.uimodel.agents

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class AgentDetailItem (
    var agentDescription : String ?= "",
    var agentIcon : String ?= "",
    var agentName : String ?= "",
    var fullPortraitV2 : String ?= "",
    var roleName : String ?= "",
    var uuid : String ?= "",
    var abilities : List<AbilityItem> ?= arrayListOf(),
)

@Parcelize
data class AbilityItem(
    var description: String? = "",
    var displayIcon: String? = "",
    var displayName: String? = "",
): Parcelable