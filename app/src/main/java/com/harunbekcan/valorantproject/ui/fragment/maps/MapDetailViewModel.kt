package com.harunbekcan.valorantproject.ui.fragment.maps

import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.ui.mapper.maps.MapDetailMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapDetailViewModel @Inject constructor(private val mapDetailMapper: MapDetailMapper): ViewModel() {

}