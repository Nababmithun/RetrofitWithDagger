package com.sgemin.daggertwoex.di.module

import android.content.Context
import com.sgemin.daggertwoex.di.qualifier.ApplicationContext
import com.sgemin.daggertwoex.di.scopes.ApplicationScope
import dagger.Module
import dagger.Provides

/**
 * Created by Stephen Gemin on 8/31/2019
 */ 
@Module
class ContextModule(private var context: Context) {

    @Provides
    @ApplicationScope
    @ApplicationContext
    fun provideContext(): Context {
        return context
    }

}