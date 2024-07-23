package com.suanki.appliedTwo.demo.food.domain.api

import com.suanki.appliedTwo.demo.food.domain.allFoods

object FindFood {
  def lookupFood(name: String): Option[Dessert] = allFoods.lookupDessert(name)
}
