package com.sgemin.daggertwoex.di.module

import android.content.Context
import com.sgemin.daggertwoex.di.qualifier.ActivityContext
import com.sgemin.daggertwoex.di.scopes.ActivityScope
import com.sgemin.daggertwoex.ui.MainActivity
import dagger.Module
import dagger.Provides

/**
 * Created by Stephen Gemin on 9/1/2019
 */
@Module
class MainActivityContextModule(private val mainActivity: MainActivity) {
    var context: Context

    init {
        context = mainActivity
    }

    @Provides
    @ActivityScope
    fun providesMainActivity(): MainActivity {
        return mainActivity
    }

    @Provides
    @ActivityScope
    @ActivityContext
    fun provideContext(): Context {
        return context
    }
}
