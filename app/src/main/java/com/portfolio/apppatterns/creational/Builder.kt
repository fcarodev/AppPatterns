package com.portfolio.apppatterns.behavioral


/**
 * Builder
  At a certain restaurant, you create your own sandwich: you choose the bread,
  ingredients and condiments you’d like on your sandwich from a checklist on a slip of paper.
  Even though the checklist instructs you to build your own sandwich,
  you only fill out the form and hand it over the counter. You don’t build the sandwich,
  just customize and consume it. :]
 */
class FoodOrder private constructor(
    val bread: String?,
    val condiments: String?,
    val meat: String?,
    val fish: String?
) {

    data class Builder(
        var bread: String? = null,
        var condiments: String? = null,
        var meat: String? = null,
        var fish: String? = null
    ) {

        fun bread(bread: String) = apply { this.bread = bread }
        fun condiments(condiments: String) = apply { this.condiments = condiments }
        fun meat(meat: String) = apply { this.meat = meat }
        fun fish(fish: String) = apply { this.fish = fish }
        fun build() = FoodOrder(bread, condiments, meat, fish)
    }
}