package com.masterchef.data.collection.utils

import java.util.Properties
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object KafkaUtils {
  private lazy val topic = ConfigProvider.getKafkaTopic
  private lazy val brokers = ConfigProvider.getKafkaBrokers
  private lazy val producer = new KafkaProducer[String, String](getProperties)

  private def getProperties:Properties = {
    val props = new Properties()
    props.put("bootstrap.servers", brokers)
    props.put("client.id", "master-chef-data-generator")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props
  }

  def pushToKafka(messages:List[String]):Unit = {
    val records = messages.map { msg =>
      new ProducerRecord[String,String](topic,msg)
    }

    records.foreach(data => producer.send(data))
  }
}
