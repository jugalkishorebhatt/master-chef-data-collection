package com.masterchef.data.collection

import com.masterchef.data.collection.models.{BookingMessage, TrafficMessage}
import com.masterchef.data.collection.utils.MockDataProvider
import org.json4s.DefaultFormats
import org.json4s.jackson.Serialization.write

object Generator {
  def main(args: Array[String]): Unit = {

    implicit val formats = DefaultFormats

    val traffic = MockDataProvider.getTrafficData
    val booking = MockDataProvider.getBookingData

    val trafficData = MockDataProvider.appendTrafficLogTime(traffic.extract[List[TrafficMessage]])
    val bookingData = MockDataProvider.appendBookingLogTime(booking.extract[List[BookingMessage]])

    for(i <- trafficData) yield println(write(i))
    for (i <- bookingData) yield println(write(i))

  }
}
