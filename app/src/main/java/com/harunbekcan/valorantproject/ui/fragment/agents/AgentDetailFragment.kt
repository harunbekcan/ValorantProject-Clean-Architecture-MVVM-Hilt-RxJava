package com.harunbekcan.valorantproject.ui.fragment.agents

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.harunbekcan.valorantproject.R
import com.harunbekcan.valorantproject.base.BaseFragment
import com.harunbekcan.valorantproject.data.uimodel.agents.AgentDetailItem
import com.harunbekcan.valorantproject.databinding.FragmentAgentDetailBinding
import com.harunbekcan.valorantproject.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentDetailFragment : BaseFragment<FragmentAgentDetailBinding>() {

    private val viewModel : AgentDetailViewModel by viewModels()
    private val args : AgentDetailFragmentArgs by navArgs()

    override fun getLayoutId(): Int = R.layout.fragment_agent_detail

    override fun prepareView(savedInstanceState: Bundle?) {
        viewModel.agentDetailRequest(args.uuid)
        initAgentDetailResponseObserve()
        initBackButtonClickListener()
    }

    private fun initBackButtonClickListener(){
        binding.agentDetailLayout.backButtonImageView.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initUi(agentDetailItem: AgentDetailItem) {
        binding.agentDetailLayout.apply {
            agentDetailItem.let { item ->
                agentIconImageView.loadImage(item.agentIcon)
                agentNameTextView.text = item.agentName
                roleTextView.text = item.roleName
                descriptionTextView.text = item.agentDescription
            }
        }
    }
    private fun initAgentDetailResponseObserve() {
        viewModel.agentDetailResponseObserve.observe(viewLifecycleOwner){
            viewModel.mapOnAgentDetailResponse(it)
            initUi(viewModel.getAgentDetailItem())
        }
    }
}