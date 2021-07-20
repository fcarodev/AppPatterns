package com.portfolio.apppatterns.structural

//1
interface Salad {
    fun getIngredient(): String
}

//2
class PlainSalad : Salad {
    override fun getIngredient(): String {
        return "Arugula & Lettuce"
    }
}

//3
open class SaladDecorator(protected var salad: Salad) : Salad {
    override fun getIngredient(): String {
        return salad.getIngredient()
    }
}

//4
class Cucumber(salad: Salad) : SaladDecorator(salad) {
    override fun getIngredient(): String {
        return salad.getIngredient() + ", Cucumber"
    }
}

//5
class Carrot(salad: Salad) : SaladDecorator(salad) {
    override fun getIngredient(): String {
        return salad.getIngredient() + ", Carrot"
    }
}