package com.muath.tawseelaapp.majed.models

import java.util.*

data class Request(
    val nameRequest:String,
    val prise: Double,
    var lat : Double,
    var Lng: Double,
    val time: Calendar,
    val day: String
)