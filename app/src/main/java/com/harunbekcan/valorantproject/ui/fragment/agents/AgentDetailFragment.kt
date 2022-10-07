package com.harunbekcan.valorantproject.ui.fragment.agents

import android.os.Bundle
import com.harunbekcan.valorantproject.R
import com.harunbekcan.valorantproject.base.BaseFragment
import com.harunbekcan.valorantproject.databinding.FragmentAgentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentDetailFragment : BaseFragment<FragmentAgentDetailBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_agent_detail

    override fun prepareView(savedInstanceState: Bundle?) {}

}