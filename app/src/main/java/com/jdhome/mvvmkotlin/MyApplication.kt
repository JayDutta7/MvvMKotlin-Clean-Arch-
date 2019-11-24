package com.jdhome.mvvmkotlin

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import timber.log.Timber

class MyApplication:Application() {


    override fun onLowMemory() {
        super.onLowMemory()
    }

    override fun onTerminate() {
        super.onTerminate()
    }

    override fun attachBaseContext(context: Context?) {
        super.attachBaseContext(context)
        /**initialize multiDex for over 65k methods in application class*/

    }


    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(myApplication)
    }

    private val myApplication = object : ActivityLifecycleCallbacks {

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            Timber.e("onActivityCreated--${activity.componentName.className}")
        }

        override fun onActivityStarted(activity: Activity) {
            Timber.e("onActivityStarted--${activity.componentName.className}")
        }

        override fun onActivityResumed(activity: Activity) {
            Timber.e("onActivityResumed--${activity.componentName.className}")
        }

        override fun onActivityPaused(activity: Activity) {
            Timber.e("onActivityPaused--${activity.componentName.className}")
        }

        override fun onActivityStopped(activity: Activity) {
            Timber.e("onActivityStopped--${activity.componentName.className}")
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            Timber.e("""onActivitySaveInstanceState--${activity.componentName.className}""")
        }

        override fun onActivityDestroyed(activity: Activity) {
            Timber.e("onActivityDestroyed--${activity.componentName.className}")
        }


    }
}