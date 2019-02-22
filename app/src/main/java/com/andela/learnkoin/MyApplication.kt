package com.andela.learnkoin

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.core.Koin.Companion.logger
import org.koin.dsl.module.module

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
    }
}