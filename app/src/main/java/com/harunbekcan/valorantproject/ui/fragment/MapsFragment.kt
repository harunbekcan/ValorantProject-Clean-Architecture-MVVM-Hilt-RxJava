package com.harunbekcan.valorantproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.harunbekcan.valorantproject.R
import com.harunbekcan.valorantproject.base.BaseFragment
import com.harunbekcan.valorantproject.databinding.FragmentMapsBinding


class MapsFragment : BaseFragment<FragmentMapsBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_maps

    override fun prepareView(savedInstanceState: Bundle?) {}

}