package com.harunbekcan.valorantproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harunbekcan.valorantproject.data.uimodel.agents.AgentItem
import com.harunbekcan.valorantproject.databinding.ItemAgentLayoutBinding
import com.harunbekcan.valorantproject.utils.loadImage

class AgentAdapter(private val agentAdapterList : ArrayList<AgentItem>):RecyclerView.Adapter<AgentAdapter.AgentViewHolder>() {

    class AgentViewHolder(val binding: ItemAgentLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentViewHolder {
        val binding = ItemAgentLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AgentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        holder.binding.apply {
            agentNameTextView.text = agentAdapterList[position].displayName
            agentImageView.loadImage(agentAdapterList[position].displayIcon)
        }
    }

    override fun getItemCount(): Int {
        return agentAdapterList.size
    }
}