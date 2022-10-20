package com.harunbekcan.valorantproject.data.uimodel.weapons

data class WeaponDetailItem (
    var weaponIcon : String ?= null,
    var weaponName : String ?= null,
    var weaponCategory : String ?= null,
    var uuid : String ?= null,
    var damageRangeList : ArrayList<DamageRangeItem> ?= arrayListOf(),
    var skinList : ArrayList<SkinItem> ?= arrayListOf(),
)

data class DamageRangeItem(
    var headDamage : Double ?= null,
    var bodyDamage : Int ?= null,
    var legDamage : Double ?= null,
)

data class SkinItem(
    var displayIcon : String ?= null,
    var displayName : String ?= null
)