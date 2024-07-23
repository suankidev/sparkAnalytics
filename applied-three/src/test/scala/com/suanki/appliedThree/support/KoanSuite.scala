/* Copyright (C) 2010-2018 Escalate Software, LLC. All rights reserved. */

package com.suanki.appliedThree.support

import org.scalatest.funsuite.AnyFunSuite

abstract class KoanSuite extends AnyFunSuite with StopOnFirstFailure {
  def koan(name: String)(fun: => Unit) = test(name)(fun)
}
