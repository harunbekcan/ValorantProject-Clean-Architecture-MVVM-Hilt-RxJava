package com.harunbekcan.valorantproject.ui.fragment.maps

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.harunbekcan.valorantproject.R
import com.harunbekcan.valorantproject.base.BaseFragment
import com.harunbekcan.valorantproject.data.uimodel.maps.MapDetailItem
import com.harunbekcan.valorantproject.databinding.FragmentMapDetailBinding
import com.harunbekcan.valorantproject.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapDetailFragment : BaseFragment<FragmentMapDetailBinding>() {

    private val viewModel : MapDetailViewModel by viewModels()
    private val navArgs : MapDetailFragmentArgs by navArgs()

    override fun getLayoutId(): Int = R.layout.fragment_map_detail

    override fun prepareView(savedInstanceState: Bundle?) {
        viewModel.mapDetailRequest(navArgs.uuid)
        initMapDetailItemObserve()
        initBackButton()
    }

    private fun initBackButton(){
        binding.mapDetailLayout.backButtonImageView.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initUi(mapDetailItem: MapDetailItem) {
        binding.mapDetailLayout.apply {
            mapDetailItem.let { item ->
                mapImageView.loadImage(item.mapIcon)
                mapNameTextView.text = item.mapName
                mapCoordinateTextView.text = item.mapCoordinate
            }
        }
    }

    private fun initMapDetailItemObserve() {
        viewModel.mapDetailItem.observe(viewLifecycleOwner){
            initUi(it)
        }
    }
}