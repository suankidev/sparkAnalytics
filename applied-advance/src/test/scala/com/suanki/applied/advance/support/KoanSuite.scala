/* Copyright (C) 2010-2019 Escalate Software, LLC All rights reserved. */

package com.suanki.applied.advance.support

import org.scalatest.funsuite.AnyFunSuite

abstract class KoanSuite extends AnyFunSuite with StopOnFirstFailure {
  def koan(name: String)(fun: => Unit) = test(name)(fun)
}
