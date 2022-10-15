package com.harunbekcan.valorantproject.ui.adapter.agents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harunbekcan.valorantproject.data.uimodel.agents.AbilityItem
import com.harunbekcan.valorantproject.databinding.ItemAbilityLayoutBinding
import com.harunbekcan.valorantproject.utils.loadImage

class AbilitiesAdapter(private val abilitiesAdapterList : ArrayList<AbilityItem>): RecyclerView.Adapter<AbilitiesAdapter.AbilitiesViewHolder>() {

    class AbilitiesViewHolder(val binding: ItemAbilityLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilitiesViewHolder {
        val binding = ItemAbilityLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AbilitiesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AbilitiesViewHolder, position: Int) {
        holder.binding.apply {
            abilityDescriptionTextView.text = abilitiesAdapterList[position].description
            abilityTitleTextView.text = abilitiesAdapterList[position].displayName
            abilityImageView.loadImage(abilitiesAdapterList[position].displayIcon)
        }
    }

    override fun getItemCount(): Int {
        return abilitiesAdapterList.size
    }
}