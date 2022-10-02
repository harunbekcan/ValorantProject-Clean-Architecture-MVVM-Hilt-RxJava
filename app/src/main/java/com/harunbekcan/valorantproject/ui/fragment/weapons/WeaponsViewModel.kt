package com.harunbekcan.valorantproject.ui.fragment.weapons

import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.ui.mapper.weapons.WeaponsMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeaponsViewModel @Inject constructor(private val weaponsMapper: WeaponsMapper):ViewModel() {
}