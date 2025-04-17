package com.servicemycar.android.app

import android.app.Application
import com.servicemycar.android.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber


class SMCApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin {
            androidContext(this@SMCApp)
            androidLogger()
            modules(appModule)
        }
    }
}
