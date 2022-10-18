package com.harunbekcan.valorantproject.ui.fragment.weapons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.data.uimodel.weapons.WeaponsItem
import com.harunbekcan.valorantproject.data.usecase.weapons.WeaponsUseCase
import com.harunbekcan.valorantproject.ui.mapper.weapons.WeaponsMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeaponsViewModel @Inject constructor(
    private val weaponsUseCase: WeaponsUseCase,
    private val weaponsMapper: WeaponsMapper
) : ViewModel() {

    private val _weaponsAdapterList = MutableLiveData<ArrayList<WeaponsItem>>()
    val weaponsAdapterList : LiveData<ArrayList<WeaponsItem>> = _weaponsAdapterList

    fun weaponsRequest() {
        weaponsUseCase.execute(
            onSuccess = {
                weaponsMapper.mapOnWeaponsResponse(it)
                _weaponsAdapterList.value = weaponsMapper.weaponsAdapterList
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}