/* Copyright (C) 2010-2018 Escalate Software, LLC. All rights reserved. */

package com.suanki.appliedTwo

class Gun(val wattage: Int) {
  class Beam(val lumens: Int)
  def shoot() = new Beam(wattage * 10)
}
