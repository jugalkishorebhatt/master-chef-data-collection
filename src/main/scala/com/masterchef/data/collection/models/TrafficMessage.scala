package com.masterchef.data.collection.models

// TODO: Include uid in BookingMsg
case class TmpTrafficMsg (uid:String, origin:String, language:String, ipv4:String, device:String, browser:String, os:String, guest:Boolean)
case class TrafficMessage (uid:String, origin:String, language:String, ipv4:String, device:String, browser:String, os:String, guest:Boolean,logTime:Long)
case class TmpBookingMsg (id:String, value:Float, currency:String, mode:String, city:String, hotel:String, room:String)
case class BookingMsg (id:String, value:Float, currency:String, mode:String, city:String, hotel:String, room:String,logTime:Long)