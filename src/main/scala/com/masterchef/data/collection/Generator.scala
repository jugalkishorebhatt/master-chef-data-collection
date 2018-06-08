package com.masterchef.data.collection

import com.masterchef.data.collection.utils.MockDataProvider

object Generator {
  def main(args: Array[String]): Unit = {

    val traffic = MockDataProvider.getTrafficData
    traffic.foreach(println(_))

    val booking = MockDataProvider.getBookingData
    booking.foreach(println(_))
 //   KafkaUtils.pushToKafka(data)
  }
}
