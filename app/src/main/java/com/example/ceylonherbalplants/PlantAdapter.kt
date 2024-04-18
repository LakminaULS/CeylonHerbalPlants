package com.example.ceylonherbalplants


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ceylonherbalplants.databinding.ItemLayoutBinding // Import generated binding class

class PlantAdapter(private val plantList: List<PlantItem>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val currentItem = plantList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = plantList.size

    inner class PlantViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(plantItem: PlantItem) {
            binding.textPlantName.text = plantItem.plantName
            binding.textScientificName.text = plantItem.scientificName

            itemView.setOnClickListener {
                listener.onItemClick(plantItem)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(plantItem: PlantItem)
    }
}
