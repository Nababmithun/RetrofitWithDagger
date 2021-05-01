package com.sgemin.daggertwoex.di.component

import android.content.Context
import com.sgemin.daggertwoex.di.module.AdapterModule
import com.sgemin.daggertwoex.di.qualifier.ActivityContext
import com.sgemin.daggertwoex.di.scopes.ActivityScope
import com.sgemin.daggertwoex.ui.MainActivity
import dagger.Component

/**
 * Created by Stephen Gemin on 9/1/2019
 */
@ActivityScope
@Component(modules = [AdapterModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    @get:ActivityContext
    val context: Context

    fun injectMainActivity(mainActivity: MainActivity)
}
