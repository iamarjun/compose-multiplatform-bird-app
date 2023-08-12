package com.myapplication

import android.app.Application
import com.myapplication.di.androidModule
import di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class BirdApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BirdApplication)
            androidLogger()
            modules(appModule() + androidModule)
        }
    }
}