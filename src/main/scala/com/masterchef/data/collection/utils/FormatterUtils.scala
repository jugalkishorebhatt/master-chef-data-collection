package com.masterchef.data.collection.utils

import org.json4s.JsonAST.JInt
import org.json4s.jackson.JsonMethods
import org.json4s.JsonAST._

object FormatterUtils {
   def parseJson(content:String) = {
      JsonMethods.parse(content)
  }
}
