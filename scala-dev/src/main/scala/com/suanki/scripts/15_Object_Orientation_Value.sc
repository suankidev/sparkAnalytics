
final case class Device(wattsPerSecond:() => Int,
                         turnDeviceOn:()=>Unit,
                         turnDeviceOff:()=>Unit) {
}

class Device{
  var wattsPerSecond:()=>Int = () => 500
  var turnedDeviceOn:()=>Unit = () => "turned something on"
  var turnedDeviceOff:()=>Unit = () => "turned something off"
}


class LightBulb{

  def wattsPerSecond():Int = 100
  def turnedOn():Unit= println("Light bulb on")
  def turnedOff():Unit= println("Light bulb off")


  def toDevice:Device = {
    val device = new Device
    device.wattsPerSecond = this.wattsPerSecond
    device.turnedDeviceOn = this.turnedOn
    device.turnedDeviceOff = this.turnedOff

    device
  }

}


class TV {
  def wattsPerSecond():Int = 500

  def turnedOn(): Unit = println("tv On")

  def turnedOff(): Unit =  println("tv Off")

  def toDevice:Device = {
    val device = new Device
     device.wattsPerSecond = this.wattsPerSecond
      device.turnedDeviceOn = this.turnedOn
      device.turnedDeviceOff = this.turnedOff

    device
  }

}



//class EnergyMeter(wattsPerSecond:Int,turnDeviceOn:()=>Unit, turnDeviceOff:()=>Unit){
class EnergyMeter(device:Device) {


  private[this] var turnedOnAtMillis: Long = 0

  //getter and setter

  private[this] var _wattsConsumedInTotal: Double = 0

  def wattsConsumedInTotal: Double = _wattsConsumedInTotal // getter

  private[this] def wattsConsumedInTotal_=(newVal: Double): Unit =
    _wattsConsumedInTotal = newVal // setter


  def startMeasuring(): Unit = {
    device.turnedDeviceOn()
    turnedOnAtMillis = System.currentTimeMillis()

  }


  def stopMeasuring(): Unit = {
    device.turnedDeviceOff()
    val durationInMillis = System.currentTimeMillis() - turnedOnAtMillis
    val durationInSeconds = durationInMillis.toDouble / 1000
    wattsConsumedInTotal += device.wattsPerSecond() * durationInSeconds

  }
}
//object EnergyMeter {
//
//  def apply(device: Any): EnergyMeter = device match {
//    case lightBulb: LightBulb =>
//      new EnergyMeter(
//        wattsPerSecond = device.asInstanceOf[LightBulb].wattsPerSecond,
//        device.asInstanceOf[LightBulb].turnedOn,
//        device.asInstanceOf[LightBulb].turnedOff
//      )
//    case tv: TV =>
//      new EnergyMeter(
//        device.asInstanceOf[TV].wattsPerSecond,
//        device.asInstanceOf[TV].turnedOn,
//        device.asInstanceOf[TV].turnedOff
//      )
//    case _ =>
//      sys.error("this is not device")
//
//
//  }}



val lightBulb:LightBulb = new LightBulb()
val tv:TV = new TV()


val lightMeter =  new EnergyMeter(lightBulb.toDevice)
lightMeter.startMeasuring()
Thread.sleep(1000)
lightMeter.stopMeasuring()

lightMeter.wattsConsumedInTotal
//
//val tvMeter = EnergyMeter.apply(tv)
//
//tvMeter.startMeasuring()
//Thread.sleep(1000)
//tvMeter.stopMeasuring()
//tvMeter.wattsConsumedInTotal