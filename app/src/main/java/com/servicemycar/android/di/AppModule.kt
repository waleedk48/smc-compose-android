package com.servicemycar.android.di

import com.servicemycar.android.core.data.HttpClientFactory
import com.servicemycar.android.repos.core.CoreRepository
import com.servicemycar.android.repos.core.CoreRepositoryImpl
import com.servicemycar.android.ui.screens.intro.IntroViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::CoreRepositoryImpl).bind<CoreRepository>()

    viewModelOf(::IntroViewModel)
}