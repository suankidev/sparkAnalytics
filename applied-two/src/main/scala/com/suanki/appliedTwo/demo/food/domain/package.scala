package com.suanki.appliedTwo.demo.food

import com.suanki.appliedTwo.demo.food.domain.api.IceCream
import com.suanki.appliedTwo.demo.food.domain.internal.FoodDB

package object domain {
  lazy val allFoods: FoodDB = {
    val foodDB = new FoodDB
    foodDB.addDessert("vanilla ice cream", IceCream("Vanilla"))
    foodDB
  }
}
