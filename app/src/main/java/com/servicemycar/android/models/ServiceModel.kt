package com.servicemycar.android.models

import kotlinx.serialization.Serializable


//TODO: replace with service model coming from server.....
@Serializable
data class ServiceModel(
    val id:String,
    val name:String,
    val imgUrl:String = ""
)
