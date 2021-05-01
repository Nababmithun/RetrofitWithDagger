package com.sgemin.daggertwoex.di.component

import com.sgemin.daggertwoex.di.scopes.ActivityScope
import com.sgemin.daggertwoex.ui.DetailActivity
import dagger.Component

/**
 * Created by Stephen Gemin on 8/31/2019
 */
@ActivityScope
@Component(dependencies = [ApplicationComponent::class])
interface DetailActivityComponent {
    fun inject(detailActivity: DetailActivity)
}