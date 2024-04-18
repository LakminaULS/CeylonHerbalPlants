package com.example.ceylonherbalplants

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ceylonherbalplants.databinding.AddItemLayoutBinding

class AddPlantActivity : AppCompatActivity() {

    private lateinit var binding: AddItemLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddItemLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCancel.setOnClickListener {
            finish()
        }

        binding.btnSave.setOnClickListener {
            val plantName = binding.editTextPlantName.text.toString().trim()
            val scientificName = binding.editTextScientificName.text.toString().trim()
            val usageDetails = binding.editTextUsage.text.toString().trim()
            val imageUrl = binding.editTextImageUrl.text.toString().trim()

            if (plantName.isNotEmpty() && scientificName.isNotEmpty() && usageDetails.isNotEmpty() && imageUrl.isNotEmpty()) {
                // Create a new PlantItem
                val newPlantItem = PlantItem(plantName, scientificName, usageDetails, imageUrl)

                // Pass the newPlantItem back to MainActivity
                val resultIntent = Intent()
                resultIntent.putExtra("new_plant_item", newPlantItem)
                setResult(RESULT_OK, resultIntent)

                // Finish the activity
                finish()
            } else {
                // Display error message if any field is empty
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
