package com.harunbekcan.valorantproject.ui.fragment.agent

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.harunbekcan.valorantproject.R
import com.harunbekcan.valorantproject.base.BaseFragment
import com.harunbekcan.valorantproject.databinding.FragmentAgentsBinding
import com.harunbekcan.valorantproject.ui.adapter.agents.AgentAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentsFragment : BaseFragment<FragmentAgentsBinding>() {

    private lateinit var agentAdapter : AgentAdapter
    private val viewModel : AgentsViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_agents

    override fun prepareView(savedInstanceState: Bundle?) {
        viewModel.agentRequest()
        initAgentResponseObserve()
    }

    private fun initAdapter(){
        agentAdapter = AgentAdapter(viewModel.getAgentAdapterList())
        binding.agentRecyclerView.adapter = agentAdapter
    }

    private fun initAgentResponseObserve(){
        viewModel.agentsResponseObserve.observe(viewLifecycleOwner){
            initAdapter()
            viewModel.mapOnAgentsResponse(it)
        }
    }
}