package com.suanki.appliedTwo

import org.scalatest.SeveredStackTraces
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should

class AbstractSuit
    extends AnyFunSuite
    with should.Matchers
    with SeveredStackTraces
    with StopOnFirstFailure
