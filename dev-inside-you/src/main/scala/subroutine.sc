def isSunnyDay = true
def isRainyDay = true

def result =
  if (isSunnyDay)
    "I'm happy because it's sunny"
  else if (isRainyDay)
    "I'm sad because it's raining"
  else
    "Not sure how i feel about today"


def code:(Boolean,Boolean)=>String=(isSunnyDay,isRainyDay)=>{
    if (isSunnyDay)
        "I'm happy because it's sunny"
    else if (isRainyDay)
        "I'm sad because it's raining"
    else
        "Not sure how i feel about today"
}

def code1(isSunnyDay:Boolean,isRainyDay:Boolean):String={
    if (isSunnyDay)
        "I'm happy because it's sunny"
    else if (isRainyDay)
        "I'm sad because it's raining"
    else
        "Not sure how i feel about today"
}


def code2:(Boolean,Boolean)=>Unit ={
    (isSunnyDay,isRainyDay) =>
        def result =
            if (isSunnyDay)
                "I'm happy because it's sunny"
            else if (isRainyDay)
                "I'm sad because it's raining"
            else
                "Not sure how i feel about today"

    println(result)
}

println(result)


def f
= (first:Boolean, second:Boolean)=> {}


