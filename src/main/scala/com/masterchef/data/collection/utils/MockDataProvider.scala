package com.masterchef.data.collection.utils

object MockDataProvider {
  def getTrafficData={
    val trafficUrl = ConfigProvider.getTrafficEndpoint
    val res = HttpUtils.getResponse(trafficUrl)
    FormatterUtils.getDataArray(res)
  }

  def getBookingData={
    HttpUtils.getResponse(ConfigProvider.getBookingEndpoint)
  }
}
