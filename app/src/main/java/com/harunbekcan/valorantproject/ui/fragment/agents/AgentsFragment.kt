package com.harunbekcan.valorantproject.ui.fragment.agents

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.harunbekcan.valorantproject.R
import com.harunbekcan.valorantproject.base.BaseFragment
import com.harunbekcan.valorantproject.databinding.FragmentAgentsBinding
import com.harunbekcan.valorantproject.ui.adapter.agents.AgentsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentsFragment : BaseFragment<FragmentAgentsBinding>() {

    private lateinit var agentsAdapter : AgentsAdapter
    private val viewModel : AgentsViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_agents

    override fun prepareView(savedInstanceState: Bundle?) {
        viewModel.agentsRequest()
        initAgentsResponseObserve()
    }

    private fun initAdapter(){
        agentsAdapter = AgentsAdapter(viewModel.getAgentsAdapterList(), itemClick = {
            it.uuid?.let { uuid->
                findNavController().navigate(AgentsFragmentDirections.actionAgentsFragmentToAgentDetailFragment(uuid))
            }
        })
        binding.agentsRecyclerView.adapter = agentsAdapter
    }

    private fun initAgentsResponseObserve(){
        viewModel.agentsResponseObserve.observe(viewLifecycleOwner){
            viewModel.mapOnAgentsResponse(it)
            initAdapter()
        }
    }
}