package com.harunbekcan.valorantproject.ui.fragment.maps

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.data.response.maps.MapResponse
import com.harunbekcan.valorantproject.data.usecase.maps.MapUseCase
import com.harunbekcan.valorantproject.ui.mapper.MapMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor( private val mapUseCase: MapUseCase, private val mapMapper: MapMapper) : ViewModel() {

    val mapResponseObserve = MutableLiveData<MapResponse>()
    private val isLoad = MutableLiveData<Boolean>()

    fun mapRequest() {
        mapUseCase.execute(
            onSuccess = {
                isLoad.value = true
                mapResponseObserve.postValue(it)
            },
            onError = {
                it.printStackTrace()
            }
        )
    }

    fun getMapAdapterList() = mapMapper.getMapAdapterList()

    fun mapOnMapResponse(mapResponse: MapResponse) = mapMapper.mapOnMapResponse(mapResponse)

}