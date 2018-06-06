package com.masterchef.data.collection.models

import com.fasterxml.jackson.databind.annotation.JsonSerialize

// TODO: Include uid in BookingMsg
@JsonSerialize
case class TrafficMessage (uid:String, origin:String, language:String, ipv4:String, device:String, browser:String, os:String, guest:Boolean)
case class TimedTrafficMessage (trafficMessage:TrafficMessage,logTime:Long)

case class BookingMessage (id:String, value:Float, currency:String, mode:String, city:String, hotel:String, room:String)
case class TimedBookingMessage(bookingMessage:BookingMessage, logTime:Long)