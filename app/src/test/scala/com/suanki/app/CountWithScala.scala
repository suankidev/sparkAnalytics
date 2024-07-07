package com.suanki.app

import org.scalatest.flatspec.AnyFlatSpec

class CountWithScala extends AnyFlatSpec {

  it should ("match the greeting word") in {

    assert("pihu" == App.greeting("pihu"))
  }

  it should ("match the name") in {

    assert("sujeet" == App.greeting("sujeet"))
  }

}
