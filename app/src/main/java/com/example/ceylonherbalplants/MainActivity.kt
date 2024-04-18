package com.example.ceylonherbalplants

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ceylonherbalplants.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PlantAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var plantList: MutableList<PlantItem>
    private lateinit var adapter: PlantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize plantList and add sample data
        plantList = mutableListOf(
            PlantItem("Nidikumba (නිදිකුම්බා)", "Mimosa pudica", "Treatment for:" +
                    "\tDysentery\n" +
                    "Diarrhea\n" +
                    "Bronchitis\n" +
                    "Bleeding wounds\n" +
                    "Bleeding ulcers\n" +
                    "Convulsions\n" +
                    "Bladder stones\n" +
                    "Urinary diseases\n" +
                    "Hydrocoele\n" +
                    "Swellings\n" +
                    "Piles\n" +
                    "Fistula", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Mimosa_pudica_in_September_month.jpg/1280px-Mimosa_pudica_in_September_month.jpg"),
            PlantItem("Ambarella (ඇඹරැල්ල)", "Spondias dulcis", "Treatment for:" +
                    "\tEarache\n" +
                    "Burning sensations\n" +
                    "Diabetes mellitus\n" +
                    "Endometritis\n" +
                    "Urinary tract infections\n" +
                    "Dysentery\n" +
                    "Pains", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dc/2014-10-11_Spondias_dulcis_Goldpflaume_anagoria.JPG/1024px-2014-10-11_Spondias_dulcis_Goldpflaume_anagoria.JPG")
        )

        // Initialize RecyclerView and set up adapter
        adapter = PlantAdapter(plantList, this)
        binding.recyclerViewPlants.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewPlants.adapter = adapter

        // Set click listener for Add Plant button
        binding.btnAddPlant.setOnClickListener {
            val intent = Intent(this, AddPlantActivity::class.java)
            startActivityForResult(intent, ADD_PLANT_REQUEST)
        }
    }

    override fun onItemClick(plantItem: PlantItem) {
        // Handle item click (e.g., show detailed view)
        val intent = Intent(this, DetailedItemActivity::class.java).apply {
            putExtra("plant_item", plantItem)
        }
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_PLANT_REQUEST && resultCode == Activity.RESULT_OK) {
            // Retrieve new plant item from AddPlantActivity
            val newPlantItem = data?.getParcelableExtra<PlantItem>("new_plant_item")

            if (newPlantItem != null) {
                // Add new plant item to the list
                plantList.add(newPlantItem)
                adapter.notifyDataSetChanged()
            }
        }
    }

    companion object {
        private const val ADD_PLANT_REQUEST = 1
    }
}
