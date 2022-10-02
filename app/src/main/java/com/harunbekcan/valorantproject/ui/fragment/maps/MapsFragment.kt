package com.harunbekcan.valorantproject.ui.fragment.maps

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.harunbekcan.valorantproject.R
import com.harunbekcan.valorantproject.base.BaseFragment
import com.harunbekcan.valorantproject.databinding.FragmentMapsBinding
import com.harunbekcan.valorantproject.ui.adapter.maps.MapsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapsFragment : BaseFragment<FragmentMapsBinding>() {

    private lateinit var mapsAdapter : MapsAdapter
    private val viewModel : MapsViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_maps

    override fun prepareView(savedInstanceState: Bundle?) {
        viewModel.mapsRequest()
        initMapsResponseObserve()
    }

    private fun initAdapter(){
        mapsAdapter = MapsAdapter(viewModel.getMapsAdapterList())
        binding.mapsRecyclerView.adapter = mapsAdapter
    }

    private fun initMapsResponseObserve(){
        viewModel.mapsResponseObserve.observe(viewLifecycleOwner){
            initAdapter()
            viewModel.mapOnMapsResponse(it)
        }
    }

}