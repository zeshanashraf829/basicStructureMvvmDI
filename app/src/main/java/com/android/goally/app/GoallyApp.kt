package com.android.goally.app

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.ktx.Firebase
import com.intuit.sdp.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GoallyApp : Application(), LifecycleObserver {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    init {
        instance = this
    }

    companion object {
        lateinit var instance: GoallyApp
        var isAppInForeground = false

        fun applicationContext(): Context {
            return instance.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        firebaseAnalytics = Firebase.analytics
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)

        //to disable dark mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)


        //disable sentry and firebase for debug builds
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(!BuildConfig.DEBUG)
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onAppForegrounded() {
        isAppInForeground = true
        println("*** called onResume()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppBackgrounded() {
        isAppInForeground = false
        println("*** called onStop()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onAppKilled() {
        isAppInForeground = false
        println("*** called onDestroy()")
    }
}