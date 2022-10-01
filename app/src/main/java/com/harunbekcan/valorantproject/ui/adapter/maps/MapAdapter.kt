package com.harunbekcan.valorantproject.ui.adapter.maps

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harunbekcan.valorantproject.data.uimodel.maps.MapItem
import com.harunbekcan.valorantproject.databinding.ItemMapLayoutBinding
import com.harunbekcan.valorantproject.utils.loadImage

class MapAdapter(private val mapAdapterList : ArrayList<MapItem>): RecyclerView.Adapter<MapAdapter.MapViewHolder>() {

    class MapViewHolder(val binding: ItemMapLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapViewHolder {
        val binding = ItemMapLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MapViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MapViewHolder, position: Int) {
        holder.binding.apply {
            mapNameTextView.text = mapAdapterList[position].displayName
            mapImageView.loadImage(mapAdapterList[position].mapIcon)
        }
    }

    override fun getItemCount(): Int {
        return mapAdapterList.size
    }
}