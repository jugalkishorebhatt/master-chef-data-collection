package com.masterchef.data.collection.utils

import com.typesafe.config.ConfigFactory

object ConfigProvider {
  private lazy val config = ConfigFactory.load("application.conf").getConfig("api.endpoint")

  def getTrafficEndpoint:String = {
    config.getString("traffic")
  }

  def getBookingEndpoint:String = {
    config.getString("booking")
  }
}
