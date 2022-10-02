package com.harunbekcan.valorantproject.ui.adapter.agents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harunbekcan.valorantproject.data.uimodel.agents.AgentsItem
import com.harunbekcan.valorantproject.databinding.ItemAgentLayoutBinding
import com.harunbekcan.valorantproject.utils.loadImage

class AgentsAdapter(private val agentsAdapterList : ArrayList<AgentsItem>):RecyclerView.Adapter<AgentsAdapter.AgentsViewHolder>() {

    class AgentsViewHolder(val binding: ItemAgentLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentsViewHolder {
        val binding = ItemAgentLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AgentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AgentsViewHolder, position: Int) {
        holder.binding.apply {
            agentNameTextView.text = agentsAdapterList[position].displayName
            agentImageView.loadImage(agentsAdapterList[position].displayIcon)
        }
    }

    override fun getItemCount(): Int {
        return agentsAdapterList.size
    }
}