/* Copyright (C) 2010-2018 Escalate Software, LLC. All rights reserved. */

package com.suanki.appliedThree

import com.suanki.appliedThree.support.StopOnFirstFailure
import org.scalatest.SeveredStackTraces
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Module14Solutions
    extends AnyFunSuite
    with Matchers
    with StopOnFirstFailure
    with SeveredStackTraces {

  // for the first part of this exercise, we are going to continue the DNA exercise from the previous
  // example and extend it. Perhaps out of interest you might like to look at the implementations of
  // the methods below and compare them to your own solutions to exercise 14.

  def stringToSetOfChars(s1: String) = s1.toList.map { c => Set(c) }

  def combineZippedSetsAndString(
      s1: List[Set[Char]],
      seq: String
  ): List[Set[Char]] =
    for ((set, char) <- (s1 zip seq.toList)) yield set + char

  def comboSetsForSequences(sequences: List[String]) = {
    val head :: rest = sequences
    val startingSet = stringToSetOfChars(head)
    rest.foldLeft(startingSet) { combineZippedSetsAndString(_, _) }
  }

  val listOfSeqs = List("GTAAGCTTAC", "GACAGCT-AC", "G-AACCTAAC", "C-AACCTAAC")

  // if you remember, we wanted the following test to pass:
  test("Find all combinations from sequences") {
    val allCombos = comboSetsForSequences(listOfSeqs)
    allCombos.toString should be(
      "List(Set(G, C), Set(T, A, -), Set(A, C), Set(A), Set(G, C), Set(C), Set(T), Set(T, -, A), Set(A), Set(C))"
    )
  }

  // now for your extensions:
  //
  // We are intending to filter out any sets with only one possible allele
  // in them, but before we can do that we need to save the original position
  // in the sequence, otherwise when we remove the single item sets we won't
  // know where the locations for the retained sets were originally.
  //
  // With this in mind, we want to get the index of the position for each Set
  // in the list, then filter out the Sets of size one (and indices for those)
  //
  // So, starting with the list of sets, zip them with an index so that they
  // become a list pairs (tuple2) of the set with an index number for each position.
  // You can do this inline in the test or write your own function, your call...
  // Check the test below if the description is confusing to see what result is expected

  test("Combo list zipped with index") {
    // this is the part you have to fill in...
    val comboListWithIndex = comboSetsForSequences(listOfSeqs).zipWithIndex

    comboListWithIndex.toString should be(
      "List((Set(G, C),0), (Set(T, A, -),1), (Set(A, C),2), (Set(A),3), (Set(G, C),4), (Set(C),5), (Set(T),6), (Set(T, -, A),7), (Set(A),8), (Set(C),9))"
    )
  }

  // Next, we want to filter out all those where the set size is 1.
  // You can do this in-line in the test, rather than writing out another function.
  // Note that you have a Set,Index tuple now, so you have to filter over
  // the first item in the tuple (the Set) having a size greater than 1
  // For convenience later, we also want to swap the order of the tuple
  // so that the index is the first thing, and the set is the second.
  // Again, check the expected results in the test for more clarity

  test("Combo list with index filtered") {
    // make the filteredListWithIndex hold the filtered list, with the indices - either as an inline
    // solution, or as a function, your choice. At the same time as you are filtering, reverse the order
    // so that the index is first, and the set is second
    val comboListWithIndex = comboSetsForSequences(listOfSeqs).zipWithIndex
    val filteredListWithIndex =
      for ((set, idx) <- comboListWithIndex if (set.size > 1)) yield (idx, set)

    filteredListWithIndex.toString should be(
      "List((0,Set(G, C)), (1,Set(T, A, -)), (2,Set(A, C)), (4,Set(G, C)), (7,Set(T, -, A)))"
    )
  }

  // we are almost there, but now we really want these results in a map, with the index as the key, and the
  // set as the value. Make the test below pass.
  // Hint, you can add a list of tuples to a Map of the right type using ++
  // perhaps this will help you? On the other hand, maybe there is a method
  // on List that can help convert to a Map directly?
  //
  // If you have trouble, try some combinations in the REPL to see if you can get it to work - try with
  // simpler types to begin with (say Int -> String)

  test("Get a mutation map from a list of sequences") {
    val comboListWithIndex = comboSetsForSequences(listOfSeqs).zipWithIndex
    val filteredListWithIndex =
      for ((set, idx) <- comboListWithIndex if (set.size > 1)) yield (idx, set)

    val mutationMap = Map.empty ++ filteredListWithIndex

    mutationMap should be(
      Map(
        0 -> Set('G', 'C'),
        1 -> Set('T', 'A', '-'),
        2 -> Set('A', 'C'),
        4 -> Set('G', 'C'),
        7 -> Set('T', '-', 'A')
      )
    )
  }

  // Alright - enough with the DNA examples - let's play with collections some more.

  test("Convert various types to a List") {
    // starting from the following objects, convert each of them to a List
    // Use the REPL to have a look at the methods on the List object, and the methods on the types
    // to see if you can come up with combinations that make it easier.

    val t = (1, 3, 5, "seven") // a tuple

    // convert it below
    val tAsList = t.productIterator.toList

    tAsList should be(List(1, 3, 5, "seven"))

    val a = Array(3, 5, '7', "nine")

    // convert it below
    val aAsList = a.toList

    aAsList should be(List(3, 5, '7', "nine"))

    val s = Set(2, 3, 5, 7, 11)

    // tricky one - convert s to a list and then write a test for it - does it work? If not, why not, and
    // can you find a safe way to make it work?
    s.toList.sorted should be(List(2, 3, 5, 7, 11))
  }

  // extra credit
  // you now have the ability to write tests and specs, manipulate lists and other collections, do pattern matching
  // of arbitrary combinations of classes and data structures, write closures and functions and a whole lot more.
  // The sky is the limit. Why not use the area below and the REPL to just experiment for a while. Set yourself
  // some challenges and see if you can make them happen, test them, and get the most elegant solution. If you
  // have trouble getting started, here are a few suggestions:
  //
  // 1. Starting with a map of keys and values, create a list of tuples of the key value pairs sorted by key,
  // then do the same thing sorted by value. Try writing your tests first and getting them to work that way
  //
  // 2. Following the examples in the test above - converting things to Lists, try converting things to Seq or
  // Traversable instead. Have a look around the methods on the various collections, and see what else you
  // can find out about them.
  //
  // 3. Also from the above example, extend the tests to see what generic type signature the Lists or Sequences
  // have for particular sequences of data, for example, what type does List(1, 2.0, 3.333) have? How about List("Hello", 'a')
  //
  // 4. Try experimenting with different types of Maps. Perhaps you can create a mutation map from the DNA
  // examples, but then find a way to convert it into a TreeMap so that the results are sorted. You can test
  // the sort order by comparing the treemap.toString to a string you specify
}
