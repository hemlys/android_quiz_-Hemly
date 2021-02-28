package com.sample.demo.myapplication

import android.app.Application
import com.sample.demo.myapplication.ui.myModule
import com.sample.demo.myapplication.ui.repoModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // Android context
            androidContext(this@MyApplication)
            // modules
            val list = listOf(myModule, repoModule)
            modules(list)
        }
    }
}