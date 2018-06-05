package com.masterchef.data.collection.utils

import com.masterchef.data.collection.models.{BookingMsg, TmpBookingMsg, TmpTrafficMsg, TrafficMessage}
import org.json4s.jackson.Serialization.write

object MockDataProvider {
  def getTrafficData = {
    val trafficUrl = ConfigProvider.getTrafficEndpoint
    val res = HttpUtils.getResponse(trafficUrl)
    FormatterUtils.parseJson(res)
  }

  def getBookingData = {
    val bookingUrl = ConfigProvider.getBookingEndpoint
    val res = HttpUtils.getResponse(bookingUrl)
    FormatterUtils.parseJson(res)
  }


  // TODO: Needs to be made generic 
  def appendTrafficLogTime(data: List[TmpTrafficMsg]) = {

    data.map {
      e =>
        TrafficMessage(
          uid = e.uid,
          origin = e.origin,
          language = e.language,
          ipv4 = e.ipv4,
          device = e.device,
          browser = e.browser,
          os = e.os,
          guest = e.guest,
          logTime = System.currentTimeMillis())
    }
  }

  def appendBookingLogTime(data: List[TmpBookingMsg]) = {

    data.map {
      e =>
        BookingMsg(
          id = e.id,
          value = e.value,
          currency = e.currency,
          mode = e.mode,
          city = e.city,
          hotel = e.hotel,
          room = e.room,
          logTime = System.currentTimeMillis())
    }
  }
}
