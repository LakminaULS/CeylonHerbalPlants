package com.example.ceylonherbalplants

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.ceylonherbalplants.databinding.DetailedItemLayoutBinding // Import generated binding class

class DetailedItemActivity : AppCompatActivity() {

    private lateinit var binding: DetailedItemLayoutBinding // Declare binding variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailedItemLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val plantItem = intent.getParcelableExtra<PlantItem>("plant_item")

        plantItem?.let {
            binding.textPlantNameDetail.text = it.plantName
            binding.textScientificNameDetail.text = it.scientificName
            binding.textUsageDetail.text = it.usageDetails

            Glide.with(this)
                .load(it.imageUrl)
                .placeholder(R.drawable.herb)
                .into(binding.imagePlant)
        }
    }
}
