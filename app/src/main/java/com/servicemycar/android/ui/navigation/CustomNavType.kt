package com.servicemycar.android.ui.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.servicemycar.android.models.ServiceModel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonDecoder

object CustomNavType {
    val ServiceType = object : NavType<ServiceModel>(
        isNullableAllowed = false
    ) {
        override fun get(bundle: Bundle, key: String): ServiceModel? {
            return bundle.getString(key)?.let { Json.decodeFromString(it) }
        }

        override fun parseValue(value: String): ServiceModel {
           return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: ServiceModel): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: ServiceModel) {
            bundle.putString(key,Json.encodeToString(value))
        }
    }

    val StringType = object : NavType<String>(
        isNullableAllowed = false
    ) {
        override fun get(bundle: Bundle, key: String): String? {
            return  bundle.getString(key)
        }

        override fun parseValue(value: String): String {
         return  Json.decodeFromString(value)
        }

        override fun put(bundle: Bundle, key: String, value: String) {
            bundle.putString(key,Json.encodeToString(value))
        }

    }
}