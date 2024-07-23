package com.suanki.appliedTwo.demo

import com.suanki.appliedTwo.demo.food.domain.api.FindFood
import com.suanki.appliedTwo.demo.wine.domain.api.PairWine
import com.suanki.appliedTwo.domain.Logger

object PairDemo extends App {
  for {
    dessert <- FindFood.lookupFood("vanilla ice cream")
    wine <- PairWine.pairWineWithDessert(dessert)
  } Logger.log(s"$dessert pairs with $wine")
}
