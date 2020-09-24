package com.example.planetsapptraining

data class Planet (val name : String, val shortDescription : String) {
    override fun toString(): String {
        return name
    }
}