package com.harunbekcan.valorantproject.ui.fragment.maps

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.data.uimodel.maps.MapsItem
import com.harunbekcan.valorantproject.data.usecase.maps.MapsUseCase
import com.harunbekcan.valorantproject.ui.mapper.maps.MapsMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(private val mapsUseCase: MapsUseCase, private val mapsMapper: MapsMapper) : ViewModel() {

    private val _mapsAdapterList = MutableLiveData<ArrayList<MapsItem>>()
    val mapsAdapterList : LiveData<ArrayList<MapsItem>> = _mapsAdapterList

    fun mapsRequest() {
        mapsUseCase.execute(
            onSuccess = {
                mapsMapper.mapOnMapsResponse(it)
                _mapsAdapterList.value = mapsMapper.mapsAdapterList
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}