package org.project.demo.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.project.demo.expect.initKoin

/**
 * Created by taieb.slama on 14/07/2025 .
 * Copyright (c) 2023. All rights reserved.
 */
class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@DemoApp)
        }
    }

}