package com.masterchef.data.collection.utils

import com.masterchef.data.collection.models._

object MockDataProvider {

  def getTrafficData:List[String] = {
    val trafficUrl = ConfigProvider.getTrafficEndpoint
    val trafficData = FormatterUtils.getData[TrafficMessage](trafficUrl)

    trafficData
  }

  def getBookingData = {
    val bookingUrl = ConfigProvider.getBookingEndpoint
    val bookingData = FormatterUtils.getData[BookingMessage](bookingUrl)

    bookingData
  }
}
