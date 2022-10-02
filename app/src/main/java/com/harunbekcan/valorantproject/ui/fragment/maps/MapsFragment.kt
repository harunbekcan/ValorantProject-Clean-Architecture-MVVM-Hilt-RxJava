package com.harunbekcan.valorantproject.ui.fragment.maps

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.harunbekcan.valorantproject.R
import com.harunbekcan.valorantproject.base.BaseFragment
import com.harunbekcan.valorantproject.databinding.FragmentMapsBinding
import com.harunbekcan.valorantproject.ui.adapter.maps.MapAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapsFragment : BaseFragment<FragmentMapsBinding>() {

    private lateinit var mapAdapter : MapAdapter
    private val viewModel : MapsViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_maps

    override fun prepareView(savedInstanceState: Bundle?) {
        viewModel.mapRequest()
        initMapResponseObserve()
    }

    private fun initAdapter(){
        mapAdapter = MapAdapter(viewModel.getMapAdapterList())
        binding.mapsRecyclerView.adapter = mapAdapter
    }

    private fun initMapResponseObserve(){
        viewModel.mapsResponseObserve.observe(viewLifecycleOwner){
            initAdapter()
            viewModel.mapOnMapsResponse(it)
        }
    }

}