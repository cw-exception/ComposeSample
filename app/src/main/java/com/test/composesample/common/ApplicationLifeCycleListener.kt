package com.exam.sample.common

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class ApplicationLifeCycleListener(private val lifeCycleListenerCallback: LifeCycleListenerCallback) : LifecycleObserver {
    interface LifeCycleListenerCallback {
        fun lifeCycleCallback(event: Lifecycle.Event)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onMoveToForeground() {
        lifeCycleListenerCallback.lifeCycleCallback(Lifecycle.Event.ON_START)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onMoveToBackground() {
        lifeCycleListenerCallback.lifeCycleCallback(Lifecycle.Event.ON_STOP)
    }
}
