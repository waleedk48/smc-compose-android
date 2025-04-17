package com.servicemycar.android.repos.core

import com.servicemycar.android.core.data.constructUrl
import com.servicemycar.android.core.data.safeCall
import com.servicemycar.android.core.domain.util.NetworkError
import com.servicemycar.android.core.domain.util.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.serialization.json.JsonObject

class CoreRepositoryImpl(private val httpClient: HttpClient):CoreRepository {

    override suspend fun  generalSettings(): Result<JsonObject,NetworkError> {
        return safeCall<JsonObject> {
                httpClient.get( urlString = constructUrl("/generalSetting"))
        }
    }

}