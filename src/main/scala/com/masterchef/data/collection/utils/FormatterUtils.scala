package com.masterchef.data.collection.utils

object FormatterUtils {
 def getDataArray(data:String):Array[String] = {
   data
     .replace("[","")
     .replace("]","")
     //.replace("},","}|")
     .split("|")
 }
}
