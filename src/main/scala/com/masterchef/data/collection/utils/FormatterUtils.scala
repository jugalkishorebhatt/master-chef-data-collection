package com.masterchef.data.collection.utils

import com.masterchef.data.collection.models.Timed
import org.json4s.{DefaultFormats, JValue}
import org.json4s.jackson.JsonMethods
import org.json4s.jackson.Serialization.write

object FormatterUtils {
  implicit val formats = DefaultFormats

  private def castAs[T:Manifest](jsValue:JValue):T = {
    jsValue.extract[T]
  }

  private def getTimedMessage[T](message:List[T]):List[Timed[T]] = {
    message.map {
      msg => Timed(msg,logTime = System.currentTimeMillis())
    }
  }

  def getData[T:Manifest](url:String):List[String] = {
    val jsValue = JsonMethods.parse(HttpUtils.getResponse(url)) //http response from api

    val castedMessage = castAs[List[T]](jsValue) //List[TrafficMessage]

    val timedMessage = getTimedMessage(castedMessage) //List[Timed[TrafficMessage]]

    val formattedData = for(i <- timedMessage) yield write(i)

    formattedData
  }
}
