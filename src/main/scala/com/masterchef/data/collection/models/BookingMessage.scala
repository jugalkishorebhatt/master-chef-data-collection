package com.masterchef.data.collection.models

import com.masterchef.data.collection.utils.MockDataProvider

case class BookingMessage(
                           id: String,
                           value: Float,
                           currency: String,
                           mode: String,
                           city: String,
                           hotel: String,
                           room: String,
                           guid: String = MockDataProvider.getTrafficGUID
                         )