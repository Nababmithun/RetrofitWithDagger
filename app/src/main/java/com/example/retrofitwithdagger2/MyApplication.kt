package com.sgemin.daggertwoex

import android.app.Activity
import android.app.Application
import com.sgemin.daggertwoex.di.component.ApplicationComponent
import com.sgemin.daggertwoex.di.component.DaggerApplicationComponent
import com.sgemin.daggertwoex.di.module.ContextModule

/**
 * Created by Stephen Gemin on 9/1/2019
 */
class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().contextModule(ContextModule(this)).build()
        applicationComponent.injectApplication(this)

    }

    companion object {

        operator fun get(activity: Activity): MyApplication {
            return activity.application as MyApplication
        }
    }
}
