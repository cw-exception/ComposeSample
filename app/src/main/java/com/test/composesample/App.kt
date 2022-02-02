package com.test.composesample

import android.app.Application
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ProcessLifecycleOwner


import androidx.work.*
import com.exam.sample.common.ApplicationLifeCycleListener

import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.TimeUnit

@HiltAndroidApp
class App : Application() {
    companion object {
        private var sApplication: Application? = null
        private var sApplicationLifecycle: Lifecycle.Event? = null

        fun getApplication(): Application {
            return sApplication!!
        }

        fun getLifeCycleApplication(): Lifecycle.Event {
            return sApplicationLifecycle ?: Lifecycle.Event.ON_START
        }
    }

    override fun onCreate() {
        super.onCreate()

        sApplication = this


        ProcessLifecycleOwner.get().lifecycle
            .addObserver(
                ApplicationLifeCycleListener(object : ApplicationLifeCycleListener.LifeCycleListenerCallback {
                    override fun lifeCycleCallback(event: Lifecycle.Event) {

                        sApplicationLifecycle = event

                        if (event == Lifecycle.Event.ON_START) {

                        } else if (event == Lifecycle.Event.ON_STOP) {

                        }
                    }
                })
            )
    }
}
