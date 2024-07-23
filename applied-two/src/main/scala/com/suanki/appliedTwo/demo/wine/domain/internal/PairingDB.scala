package com.suanki.appliedTwo.demo.wine.domain.internal

import com.suanki.appliedTwo.demo.food.domain.api.{Dessert, IceCream}
import com.suanki.appliedTwo.demo.wine.domain.api.Wine

private[domain] object PairingDB {
  private[this] val winePairs =
    Map[Dessert, Wine](
      IceCream("Vanilla") -> Wine("Solis Old Vine Zin", 2014, "Zinfandel")
    )

  def pairWineWithDessert(dessert: Dessert): Option[Wine] =
    winePairs.get(dessert)
}
