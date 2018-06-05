package com.masterchef.data.collection.utils

import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder

object HttpUtils {
  def getResponse(url: String) = {
    val httpClient = HttpClientBuilder.create.build
    val httpResponse = httpClient.execute(new HttpGet(url))
    val entity = httpResponse.getEntity
    var content = ""
    if (entity != null) {
      val inputStream = entity.getContent
      content = scala.io.Source.fromInputStream(inputStream).getLines.mkString
      inputStream.close()
    }
    httpClient.close()
    content
  }
}
