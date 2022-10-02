package com.harunbekcan.valorantproject.ui.adapter.weapons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harunbekcan.valorantproject.data.uimodel.weapons.WeaponsItem
import com.harunbekcan.valorantproject.databinding.ItemWeaponLayoutBinding
import com.harunbekcan.valorantproject.utils.loadImage

class WeaponsAdapter(private val weaponsAdapterList : ArrayList<WeaponsItem>): RecyclerView.Adapter<WeaponsAdapter.WeaponsViewHolder>() {

    class WeaponsViewHolder(val binding: ItemWeaponLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeaponsViewHolder {
        val binding = ItemWeaponLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return WeaponsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeaponsViewHolder, position: Int) {
        holder.binding.apply {
            weaponNameTextView.text = weaponsAdapterList[position].displayName
            weaponImageView.loadImage(weaponsAdapterList[position].displayIcon)
        }
    }

    override fun getItemCount(): Int {
        return weaponsAdapterList.size
    }
}