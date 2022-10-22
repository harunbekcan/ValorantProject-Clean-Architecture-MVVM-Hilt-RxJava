package com.harunbekcan.valorantproject.ui.fragment.maps

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.data.uimodel.maps.MapDetailItem
import com.harunbekcan.valorantproject.data.uimodel.weapons.WeaponDetailItem
import com.harunbekcan.valorantproject.data.usecase.maps.MapDetailUseCase
import com.harunbekcan.valorantproject.ui.mapper.maps.MapDetailMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapDetailViewModel @Inject constructor(
    private val mapDetailUseCase: MapDetailUseCase,
    private val mapDetailMapper: MapDetailMapper
) : ViewModel() {

    private val _mapDetailItem = MutableLiveData<MapDetailItem>()
    val mapDetailItem : LiveData<MapDetailItem> = _mapDetailItem

    fun mapDetailRequest(uuid:String) {
        mapDetailUseCase.mapUuid(uuid)
        mapDetailUseCase.execute(
            onSuccess = {
                mapDetailMapper.mapOnMapDetailResponse(it)
                _mapDetailItem.value = mapDetailMapper.mapDetailItem
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}