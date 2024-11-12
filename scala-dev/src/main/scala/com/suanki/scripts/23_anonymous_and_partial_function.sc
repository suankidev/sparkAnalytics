

type ~>[-T1,+R] = PartialFunction[T1,R]

def toRomanNumeralDigit(number:Int):String = {
  val partialFunction: Int ~> String = {
   case 0 => "0: N"
   case 1 => "1: X"
   case 2 => "2: XX"
   case 3 => "3: XXX"
   case 4 => "4: IV"
   case 5 => "5: V"
   case 6 => "6: VI"
   case 7 => "7: VII"
   case 8 => "8: VIII"
   case 9 => "9: IX"
   case 10 => "10: X"
  }
 partialFunction(number)
}

def onlyEvenDigits: Int ~> String = {
  case 0 => "0: N"
  case 2 => "2: XX"
  case 4 => "4: IV"
  case 6 => "6: VI"
  case 8 => "8: VIII"
  case 10 => "10: X"
}
def onlyOddDigits: Int ~> String = {
  case 0 => "0: N"
  case 1 => "1: X"
  case 3 => "3: XXX"
  case 5 => "5: V"
  case 7 => "7: VII"
  case 9 => "9: IX"
}

def toRomanNumeralDigitOne(number:Int):String = {
  val partialFunction: Int ~> String = onlyEvenDigits orElse onlyOddDigits
  partialFunction(number)
}

0 to 10 map toRomanNumeralDigit foreach println


//thats how match workd

def demo(number:Int):String = number match {
  case 0 => "0: N"
  case 1 => "1: X"
  case 2 => "2: XX"
  case 3 => "3: XXX"
  case 4 => "4: IV"
  case 5 => "5: V"
  case 6 => "6: VI"
  case 7 => "7: VII"
  case 8 => "8: VIII"
  case 9 => "9: IX"
  case 10 => "10: X"
}
0 to 10 map demo