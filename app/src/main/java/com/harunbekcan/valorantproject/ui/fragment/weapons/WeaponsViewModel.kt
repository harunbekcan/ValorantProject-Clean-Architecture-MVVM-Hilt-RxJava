package com.harunbekcan.valorantproject.ui.fragment.weapons

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.data.response.weapons.WeaponsResponse
import com.harunbekcan.valorantproject.data.usecase.weapons.WeaponsUseCase
import com.harunbekcan.valorantproject.ui.mapper.weapons.WeaponsMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeaponsViewModel @Inject constructor(
    private val weaponsUseCase: WeaponsUseCase,
    private val weaponsMapper: WeaponsMapper
) : ViewModel() {

    val weaponsResponseObserve = MutableLiveData<WeaponsResponse>()
    private val isLoad = MutableLiveData<Boolean>()

    fun weaponsRequest() {
        weaponsUseCase.execute(
            onSuccess = {
                isLoad.value = true
                weaponsResponseObserve.postValue(it)
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
    fun getWeaponsAdapterList() = weaponsMapper.getWeaponsAdapterList()
    fun mapOnWeaponsResponse(weaponsResponse: WeaponsResponse) = weaponsMapper.mapOnWeaponsResponse(weaponsResponse)
}