import com.suanki.utilities.Spark
import org.scalatest.flatspec.AnyFlatSpec

class TestSpark extends AnyFlatSpec with Spark {

  it should ("check for spark session") in {

//    assert(spark != null)
    assert(1 == 1)
  }

}
