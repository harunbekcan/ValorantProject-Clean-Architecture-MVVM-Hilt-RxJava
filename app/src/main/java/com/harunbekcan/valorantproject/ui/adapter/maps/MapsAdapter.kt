package com.harunbekcan.valorantproject.ui.adapter.maps

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harunbekcan.valorantproject.data.uimodel.maps.MapsItem
import com.harunbekcan.valorantproject.databinding.ItemMapLayoutBinding
import com.harunbekcan.valorantproject.utils.loadImage

class MapsAdapter(private val mapsAdapterList : ArrayList<MapsItem>,private val itemClick: (MapsItem) -> Unit): RecyclerView.Adapter<MapsAdapter.MapsViewHolder>() {

    class MapsViewHolder(val binding: ItemMapLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapsViewHolder {
        val binding = ItemMapLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MapsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MapsViewHolder, position: Int) {
        holder.binding.apply {
            mapNameTextView.text = mapsAdapterList[position].displayName
            mapImageView.loadImage(mapsAdapterList[position].mapIcon)

            mapCardView.setOnClickListener {
                itemClick.invoke(mapsAdapterList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return mapsAdapterList.size
    }
}