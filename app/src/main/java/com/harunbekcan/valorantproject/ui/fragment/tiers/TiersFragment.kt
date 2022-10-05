package com.harunbekcan.valorantproject.ui.fragment.tiers

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.harunbekcan.valorantproject.R
import com.harunbekcan.valorantproject.base.BaseFragment
import com.harunbekcan.valorantproject.databinding.FragmentTiersBinding
import com.harunbekcan.valorantproject.ui.adapter.tiers.TiersAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TiersFragment : BaseFragment<FragmentTiersBinding>() {

    private lateinit var tiersAdapter: TiersAdapter
    private val viewModel : TiersViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_tiers

    override fun prepareView(savedInstanceState: Bundle?) {
        viewModel.tiersRequest()
        initMapsResponseObserve()
    }

    private fun initAdapter(){
        tiersAdapter = TiersAdapter(viewModel.getTiersAdapterList())
        binding.tiersRecyclerView.adapter = tiersAdapter
    }

    private fun initMapsResponseObserve(){
        viewModel.tiersResponseObserve.observe(viewLifecycleOwner){
            initAdapter()
            viewModel.mapOnTiersResponse(it)
        }
    }
}