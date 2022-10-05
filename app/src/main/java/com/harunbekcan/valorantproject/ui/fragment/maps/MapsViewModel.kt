package com.harunbekcan.valorantproject.ui.fragment.maps

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.data.response.maps.MapsResponse
import com.harunbekcan.valorantproject.data.usecase.maps.MapsUseCase
import com.harunbekcan.valorantproject.ui.mapper.maps.MapsMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(private val mapsUseCase: MapsUseCase, private val mapsMapper: MapsMapper) : ViewModel() {

    val mapsResponseObserve = MutableLiveData<MapsResponse>()
    private val isLoad = MutableLiveData<Boolean>()

    fun mapsRequest() {
        mapsUseCase.execute(
            onSuccess = {
                isLoad.value = true
                mapsResponseObserve.postValue(it)
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
    fun getMapsAdapterList() = mapsMapper.getMapsAdapterList()
    fun mapOnMapsResponse(mapsResponse: MapsResponse) = mapsMapper.mapOnMapsResponse(mapsResponse)
}