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
        initTiersAdapterListObserve()
    }

    private fun initAdapter(){
        viewModel.tiersAdapterList.value?.let {
            tiersAdapter = TiersAdapter(it)
            binding.tiersRecyclerView.adapter = tiersAdapter
        }
    }

    private fun initTiersAdapterListObserve(){
        viewModel.tiersAdapterList.observe(viewLifecycleOwner){
            initAdapter()
        }
    }
}