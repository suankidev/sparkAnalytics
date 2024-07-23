package com.suanki.appliedTwo.demo.wine.domain.api

import com.suanki.appliedTwo.demo.food._
import domain.api.Dessert
import com.suanki.appliedTwo.demo.wine.domain.internal.PairingDB

object PairWine {
  import _root_.com.suanki.appliedTwo.domain.Logger.log
  def pairWineWithDessert(dessert: Dessert): Option[Wine] = {
    log(s"Attempting to pair $dessert")
    PairingDB.pairWineWithDessert(dessert)
  }
}
