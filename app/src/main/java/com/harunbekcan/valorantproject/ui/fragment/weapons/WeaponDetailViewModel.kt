package com.harunbekcan.valorantproject.ui.fragment.weapons

import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.data.usecase.weapons.WeaponDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeaponDetailViewModel @Inject constructor(
    private val weaponDetailUseCase: WeaponDetailUseCase,
) : ViewModel() {

}