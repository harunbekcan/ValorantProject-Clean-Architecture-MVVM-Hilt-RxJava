package com.harunbekcan.valorantproject.ui.fragment

import android.os.Bundle
import com.harunbekcan.valorantproject.R
import com.harunbekcan.valorantproject.base.BaseFragment
import com.harunbekcan.valorantproject.databinding.FragmentAgentsBinding

class AgentsFragment : BaseFragment<FragmentAgentsBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_agents

    override fun prepareView(savedInstanceState: Bundle?) {}
}