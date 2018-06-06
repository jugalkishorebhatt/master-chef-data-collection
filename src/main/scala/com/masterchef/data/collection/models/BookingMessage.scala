package com.masterchef.data.collection.models

case class BookingMessage (
                            id:String,
                            value:Float,
                            currency:String,
                            mode:String,
                            city:String,
                            hotel:String,
                            room:String,
                            //guid:String = ""
                          )

//case class TimedBookingMessage(bookingMessage:BookingMessage, logTime:Long)
