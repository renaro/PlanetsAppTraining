package com.example.planetsapptraining

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_planet_list.*

class PlanetListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_list)

        val adapterPlanets = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_list_item_1,
            PlanetMockedData.planets
        )

        listPlanets.adapter = adapterPlanets

        listPlanets.setOnItemClickListener { _, _, position, _ ->
            val planet = adapterPlanets.getItem(position) as Planet
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, "You selected ${planet.name}", duration)
            toast.show()
        }
    }
}