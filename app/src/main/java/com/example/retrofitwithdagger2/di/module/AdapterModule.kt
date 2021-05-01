package com.sgemin.daggertwoex.di.module

import com.sgemin.daggertwoex.adapter.RecyclerViewAdapter
import com.sgemin.daggertwoex.di.scopes.ActivityScope
import com.sgemin.daggertwoex.ui.MainActivity
import dagger.Module
import dagger.Provides

/**
 * Created by Stephen Gemin on 9/1/2019
 */
@Module(includes = [MainActivityContextModule::class])
class AdapterModule {

    @Provides
    @ActivityScope
    fun getStarWarsPeopleLIst(clickListener: RecyclerViewAdapter.ClickListener): RecyclerViewAdapter {
        return RecyclerViewAdapter(clickListener)
    }

    @Provides
    @ActivityScope
    fun getClickListener(mainActivity: MainActivity): RecyclerViewAdapter.ClickListener {
        return mainActivity
    }
}