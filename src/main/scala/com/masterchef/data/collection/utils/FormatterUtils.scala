package com.masterchef.data.collection.utils

import com.masterchef.data.collection.models.Timed
import org.json4s.jackson.JsonMethods
import org.json4s.jackson.Serialization.write
import org.json4s.{DefaultFormats, JValue}

object FormatterUtils {
  implicit val formats = DefaultFormats

  private def castAs[T: Manifest](jsValue: JValue): T = {
    jsValue.extract[T]
  }

  private def getTimedMessage[T](message: List[T]): List[Timed[T]] = {
    message.map {
      msg => Timed(msg, logTime = System.currentTimeMillis())
    }
  }

  def getCastedHttpResponse[T: Manifest](url: String): List[T] = {
    val jsValue = JsonMethods.parse(HttpUtils.getResponse(url)) //http response from api
    val castedMessage = castAs[List[T]](jsValue) //List[TrafficMessage]
    castedMessage
  }

  def getData[T](data: List[T]): List[String] = {
    val timedMessage = getTimedMessage(data) //List[Timed[TrafficMessage]]

    val formattedData = for (i <- timedMessage) yield write(i)

    formattedData
  }
}
