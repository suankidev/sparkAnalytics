package com.suanki.dsa

import java.util
import scala.annotation.tailrec

object ArrayUtils {

  def show(arr: Array[Int]): ArrayUtils.type = {
    println(s"o/p==> ${arr.mkString(",")}")
    this
  }

  @tailrec
  def gcd(a: Int, b: Int): Int = {
    if (b == 0 || b == 1) a
    else gcd(a = b, b = b % a)
  }

  def reverseArray(arr: Array[Int]): Array[Int] = {
    println(s"Actual array: ${arr.mkString(",")}")
    val newArray = arr.clone()
    for (idx <- arr.indices) {
      //      println(s"idx:$idx : arr.length-1: ${arr.length-1 - idx}")
      newArray(idx) = arr(arr.length - 1 - idx)
    }
    newArray
  }

  def reverseArrayWithLoop(arr: Array[Int]): Array[Int] = {
    var temp = 0

    @tailrec
    def loop(start: Int = 0, end: Int = arr.length): Array[Int] = {
      if (start > end) arr
      else {
        temp = arr(start)
        arr(start) = arr(end - 1)
        arr(end - 1) = temp
        loop(start = start + 1, end = end - 1)
      }
    }

    loop()
  }

  /** push the arr in stack,and then pop
    *
    * @param arr
    * @return
    */
  def reversedArrayWithStack(arr: Array[Int]): Array[Int] = {

    val stack = new util.Stack[Int]

    for (ar <- arr)
      stack.push(ar)

    for (idx <- arr.indices)
      arr(idx) = stack.pop()

    arr
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////   ROTATING ARRAY /////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /** Given an array of integers arr[] of size N and an integer d, the task is
    * to rotate the array elements to the left by d positions. Input: N = 7, d =
    * 2 ,arr[] = {1, 2, 3, 4, 5, 6, 7} Output: 3 4 5 6 7 1 2
    *
    * Input: N = 7, d=2 , arr[] = {3, 4, 5, 6, 7, 1, 2}, Output: 5 6 7 1 2 3 4
    *
    * How ?
    */
  def lefRotationByPosition(arr: Array[Int], pos: Int): Array[Int] = {
    require(
      pos < arr.length,
      s"rotation position should be less than arry size :${arr.length} passed: $pos"
    )
    var start = 0
    var position = pos
    var positionOne = pos
    val end = arr.length
    var newArry = arr.clone()
    while (start < end) {
      //     println(s"start:$start, end:$end, position:$position, positionOne:$positionOne")
      if (start < pos)
        newArry(end - position) = arr(start)
      if (positionOne < end)
        newArry(start) = arr(positionOne)
      start += 1
      position -= 1
      positionOne += 1
    }
    newArry
  }

  /** Suppose the give array is arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2.
    *
    * First Step: \=> Store the elements from 2nd index to the last. \=> temp[]
    * \= [3, 4, 5, 6, 7]
    *
    * Second Step: \=> Now store the first 2 elements into the temp[] array. \=>
    * temp[] = [3, 4, 5, 6, 7, 1, 2]
    *
    * Third Steps: \=> Copy the elements of the temp[] array into the original
    * array. \=> arr[] = temp[] So arr[] = [3, 4, 5, 6, 7, 1, 2]
    */

  def lefRotationByPositionWithTempArray(
      arr: Array[Int],
      pos: Int
  ): Array[Int] = {
    val tmpArray = Array.fill(arr.length)(0)
    var k = 0
    for (idx <- pos until (arr.length)) {
      tmpArray(k) = arr(idx)
      k += 1
    }

    for (idx <- 0 until pos) {
      tmpArray(k) = arr(idx)
      k += 1
    }

    // copy element to orginal arry
    for (idx <- tmpArray.indices) {
      arr(idx) = tmpArray(idx)
    }

    arr
  }

  // Rotate one by one
  /*
  1. At each iteration, shift the elements by one position to the left circularly
  (i.e., first element becomes the last).
2. Perform this operation d times to rotate the elements to the left by d position.

how?
Follow the steps below to solve the given problem.

Rotate the array to left by one position. For that do the following:
Store the first element of the array in a temporary variable.
Shift the rest of the elements in the original array by one place.
Update the last index of the array with the temporary variable.
Repeat the above steps for the number of left rotations required.
   */
  def lefRotationPositionOneByOne(arr: Array[Int], pos: Int): Array[Int] = {
    println(s"actual array: ${arr.mkString(",")}")
    var last = 0
    for (idx <- 0 until pos) {
      last = arr(0)
      for (ydx <- 0 until arr.length - 1) {
        arr(ydx) = arr(ydx + 1)
      }
      arr(arr.length - 1) = last
    }
    arr
  }

  def leftRotateByReversedAlgo(
      arr: Array[Int],
      pos: Int,
      len: Int
  ): Array[Int] = {

    @tailrec
    def loop(start: Int = 0, end: Int = 0): Unit = {
      var temp = 0
      if (start > end) arr
      else {
        temp = arr(start)
        arr(start) = arr(end)
        arr(end) = temp
        loop(start = start + 1, end = end - 1)
      }
    }

    loop(0, pos - 1)
    loop(pos, len - 1)
    loop(0, len - 1)

    arr

  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////// Print array after it is right rotated K times /////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /** Input: Array[] = {1, 3, 5, 7, 9}, K = 2. Output: 7 9 1 3 5
    *
    * Explanation: After 1st rotation – {9, 1, 3, 5, 7} After 2nd rotation – {7,
    * 9, 1, 3, 5}
    *
    * Input: Array[] = {1, 2, 3, 4, 5}, K = 4. Output: 2 3 4 5 1
    */
  def rightRotatedByPosition(arr: Array[Int], pos: Int, n: Int): Array[Int] = {

    arr
  }

}
