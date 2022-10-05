package com.harunbekcan.valorantproject.ui.adapter.tiers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harunbekcan.valorantproject.data.uimodel.tiers.TiersItem
import com.harunbekcan.valorantproject.databinding.ItemTierLayoutBinding
import com.harunbekcan.valorantproject.utils.loadImage

class TiersAdapter(private val tiersAdapterList : ArrayList<TiersItem>): RecyclerView.Adapter<TiersAdapter.TiersViewHolder>() {

    class TiersViewHolder(val binding: ItemTierLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TiersViewHolder {
        val binding = ItemTierLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TiersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TiersViewHolder, position: Int) {
        holder.binding.apply {
            tierNameTextView.text = tiersAdapterList[position].tierName
            tierImageView.loadImage(tiersAdapterList[position].tierIcon)
        }
    }

    override fun getItemCount(): Int {
        return tiersAdapterList.size
    }
}