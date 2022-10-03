package com.harunbekcan.valorantproject.ui.fragment.tiers

import androidx.lifecycle.ViewModel
import com.harunbekcan.valorantproject.ui.mapper.tiers.TiersMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TiersViewModel @Inject constructor( private val tiersMapper: TiersMapper) : ViewModel() {

}