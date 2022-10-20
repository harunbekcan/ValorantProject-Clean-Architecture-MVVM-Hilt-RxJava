package com.harunbekcan.valorantproject.ui.adapter.weapons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harunbekcan.valorantproject.data.uimodel.weapons.SkinItem
import com.harunbekcan.valorantproject.databinding.ItemSkinLayoutBinding
import com.harunbekcan.valorantproject.utils.loadImage

class SkinsAdapter(private val skinsAdapterList : ArrayList<SkinItem>): RecyclerView.Adapter<SkinsAdapter.SkinsViewHolder>() {

    class SkinsViewHolder(val binding: ItemSkinLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkinsViewHolder {
        val binding = ItemSkinLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SkinsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SkinsViewHolder, position: Int) {
        holder.binding.apply {
            skinNameTextView.text = skinsAdapterList[position].displayName
            skinImageView.loadImage(skinsAdapterList[position].displayIcon)
        }
    }

    override fun getItemCount(): Int {
        return skinsAdapterList.size
    }
}