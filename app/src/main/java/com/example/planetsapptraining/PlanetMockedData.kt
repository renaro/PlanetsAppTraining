package com.example.planetsapptraining

object PlanetMockedData {
    val planets : List<Planet>
        get() {
            var mars = Planet("Mars","Where the androids live")
            var earth = Planet("Earth", "Home sweet home")
            var mercury = Planet("Mercury", "As close as you can get")
            return listOf(mars, earth, mercury)
        }
}