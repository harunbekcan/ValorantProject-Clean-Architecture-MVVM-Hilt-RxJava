package com.harunbekcan.valorantproject.ui.fragment.tiers

import android.os.Bundle
import com.harunbekcan.valorantproject.R
import com.harunbekcan.valorantproject.base.BaseFragment
import com.harunbekcan.valorantproject.databinding.FragmentTiersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TiersFragment : BaseFragment<FragmentTiersBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_tiers

    override fun prepareView(savedInstanceState: Bundle?) {}

}