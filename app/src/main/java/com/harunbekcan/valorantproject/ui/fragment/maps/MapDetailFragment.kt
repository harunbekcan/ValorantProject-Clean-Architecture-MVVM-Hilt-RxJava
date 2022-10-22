package com.harunbekcan.valorantproject.ui.fragment.maps

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.harunbekcan.valorantproject.R
import com.harunbekcan.valorantproject.base.BaseFragment
import com.harunbekcan.valorantproject.databinding.FragmentMapDetailBinding

class MapDetailFragment : BaseFragment<FragmentMapDetailBinding>() {

    private val viewModel : MapDetailViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_map_detail

    override fun prepareView(savedInstanceState: Bundle?) {
        initBackButton()
    }

    private fun initBackButton(){
        binding.mapDetailLayout.backButtonImageView.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}