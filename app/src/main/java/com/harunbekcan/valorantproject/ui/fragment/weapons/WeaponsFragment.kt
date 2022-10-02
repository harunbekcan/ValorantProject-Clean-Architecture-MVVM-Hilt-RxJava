package com.harunbekcan.valorantproject.ui.fragment.weapons

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.harunbekcan.valorantproject.R
import com.harunbekcan.valorantproject.base.BaseFragment
import com.harunbekcan.valorantproject.databinding.FragmentWeaponsBinding
import com.harunbekcan.valorantproject.ui.adapter.weapons.WeaponsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeaponsFragment : BaseFragment<FragmentWeaponsBinding>() {

    private lateinit var weaponsAdapter: WeaponsAdapter
    private val viewModel : WeaponsViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_weapons

    override fun prepareView(savedInstanceState: Bundle?) {
        viewModel.weaponsRequest()
        initWeaponsResponseObserve()
    }

    private fun initAdapter(){
        weaponsAdapter = WeaponsAdapter(viewModel.getWeaponsAdapterList())
        binding.weaponsRecyclerView.adapter = weaponsAdapter
    }

    private fun initWeaponsResponseObserve(){
        viewModel.weaponsResponseObserve.observe(viewLifecycleOwner){
            initAdapter()
            viewModel.mapOnWeaponsResponse(it)
        }
    }

}