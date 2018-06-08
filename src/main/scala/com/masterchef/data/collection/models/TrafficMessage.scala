package com.masterchef.data.collection.models


case class TrafficMessage (
                            uid:String,
                            origin:String,
                            language:String,
                            ipv4:String,
                            device:String,
                            browser:String,
                            os:String,
                            guest:Boolean
                          )