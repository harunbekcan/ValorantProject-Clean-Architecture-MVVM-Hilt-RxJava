package com.harunbekcan.valorantproject.ui.fragment.weapons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.data.uimodel.weapons.WeaponDetailItem
import com.harunbekcan.valorantproject.data.usecase.weapons.WeaponDetailUseCase
import com.harunbekcan.valorantproject.ui.mapper.weapons.WeaponDetailMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeaponDetailViewModel @Inject constructor(
    private val weaponDetailUseCase: WeaponDetailUseCase,
    private val weaponDetailMapper: WeaponDetailMapper
) : ViewModel() {

    private val _weaponDetailItem = MutableLiveData<WeaponDetailItem>()
    val weaponDetailItem : LiveData<WeaponDetailItem> = _weaponDetailItem

    fun weaponDetailRequest(uuid:String) {
        weaponDetailUseCase.weaponUuid(uuid)
        weaponDetailUseCase.execute(
            onSuccess = {
                weaponDetailMapper.mapOnWeaponDetailResponse(it)
                _weaponDetailItem.value = weaponDetailMapper.weaponDetailItem
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}