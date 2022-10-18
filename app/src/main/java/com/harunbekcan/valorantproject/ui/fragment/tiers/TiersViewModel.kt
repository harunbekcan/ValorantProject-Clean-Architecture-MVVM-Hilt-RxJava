package com.harunbekcan.valorantproject.ui.fragment.tiers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.data.uimodel.tiers.TiersItem
import com.harunbekcan.valorantproject.data.usecase.tiers.TiersUseCase
import com.harunbekcan.valorantproject.ui.mapper.tiers.TiersMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TiersViewModel @Inject constructor( private val tiersUseCase: TiersUseCase, private val tiersMapper: TiersMapper) : ViewModel() {

    private val _tiersAdapterList = MutableLiveData<ArrayList<TiersItem>>()
    val tiersAdapterList : LiveData<ArrayList<TiersItem>> = _tiersAdapterList

    fun tiersRequest() {
        tiersUseCase.execute(
            onSuccess = {
                tiersMapper.mapOnTiersResponse(it)
                _tiersAdapterList.value = tiersMapper.tiersAdapterList
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}