package com.codixlab.retrofitandplaceautocompleteapi.di.component

import android.app.Application
import android.content.res.Resources
import com.codixlab.retrofitandplaceautocompleteapi.di.module.NetworkModule
import com.codixlab.retrofitandplaceautocompleteapi.di.module.RepositoryModule
import com.codixlab.retrofitandplaceautocompleteapi.di.module.ResourcesModule
import com.codixlab.retrofitandplaceautocompleteapi.retrofit.APIHostUrls
import com.codixlab.retrofitandplaceautocompleteapi.source.GeneralRepository
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Mustufa Ansari on 12/10/2020.
 * Copyright (c) 2020 All rights reserved.
 */

@Singleton
@Component(
    modules = [NetworkModule::class, RepositoryModule::class, ResourcesModule::class],
    dependencies = [ContextComponent::class]
)
interface BaseComponent {

    fun getResources(): Resources

    fun getBaseContext(): Application

    fun getRetrofitInstance(): APIHostUrls

    fun getGeneralRepository(): GeneralRepository

}