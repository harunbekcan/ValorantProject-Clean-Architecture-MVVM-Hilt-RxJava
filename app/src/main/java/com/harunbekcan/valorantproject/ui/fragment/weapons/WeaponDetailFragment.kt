package com.harunbekcan.valorantproject.ui.fragment.weapons

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.harunbekcan.valorantproject.R
import com.harunbekcan.valorantproject.base.BaseFragment
import com.harunbekcan.valorantproject.databinding.FragmentWeaponDetailBinding

class WeaponDetailFragment : BaseFragment<FragmentWeaponDetailBinding>() {

    private val viewModel : WeaponDetailViewModel by viewModels()
    private val navArgs : WeaponDetailFragmentArgs by navArgs()

    override fun getLayoutId(): Int = R.layout.fragment_weapon_detail

    override fun prepareView(savedInstanceState: Bundle?) {
        viewModel.weaponDetailRequest(navArgs.uuid)
        initBackButton()
    }

    private fun initBackButton(){
        binding.weaponDetailLayout.backButtonImageView.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}