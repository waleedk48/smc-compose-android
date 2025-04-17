package com.servicemycar.android.repos.core

import com.servicemycar.android.core.domain.util.NetworkError
import com.servicemycar.android.core.domain.util.Result
import kotlinx.serialization.json.JsonObject

interface CoreRepository {

    suspend fun generalSettings(): Result<JsonObject, NetworkError>
}