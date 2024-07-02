package com.suanki.app

import org.scalatest.flatspec.AnyFlatSpec

class CountWithScala extends AnyFlatSpec {


  it should("match the greeting word") in {

    assert("Pihu" == App.greeting())
  }


}