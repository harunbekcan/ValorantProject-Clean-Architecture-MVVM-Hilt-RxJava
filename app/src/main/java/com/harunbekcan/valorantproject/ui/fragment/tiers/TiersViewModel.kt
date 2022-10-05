package com.harunbekcan.valorantproject.ui.fragment.tiers

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.data.response.tiers.TiersResponse
import com.harunbekcan.valorantproject.data.usecase.tiers.TiersUseCase
import com.harunbekcan.valorantproject.ui.mapper.tiers.TiersMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TiersViewModel @Inject constructor( private val tiersUseCase: TiersUseCase, private val tiersMapper: TiersMapper) : ViewModel() {

    val tiersResponseObserve = MutableLiveData<TiersResponse>()
    private val isLoad = MutableLiveData<Boolean>()

    fun tiersRequest() {
        tiersUseCase.execute(
            onSuccess = {
                isLoad.value = true
                tiersResponseObserve.postValue(it)
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
    fun getTiersAdapterList() = tiersMapper.getTiersAdapterList()
    fun mapOnTiersResponse(tiersResponse: TiersResponse) = tiersMapper.mapOnTiersResponse(tiersResponse)
}