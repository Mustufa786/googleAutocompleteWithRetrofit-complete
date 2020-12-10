package com.codixlab.retrofitandplaceautocompleteapi

import androidx.multidex.MultiDexApplication
import com.codixlab.retrofitandplaceautocompleteapi.di.component.BaseComponent
import com.codixlab.retrofitandplaceautocompleteapi.di.component.DaggerBaseComponent
import com.codixlab.retrofitandplaceautocompleteapi.di.component.DaggerContextComponent
import com.codixlab.retrofitandplaceautocompleteapi.di.module.ContextModule

/**
 * Created by Mustufa Ansari on 12/10/2020.
 * Copyright (c) 2020 All rights reserved.
 */
open class DaggerApp : MultiDexApplication() {

    companion object {
        var component: BaseComponent? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        val applicationComponent = DaggerContextComponent
            .builder()
            .contextModule(
                ContextModule(
                    this
                )
            )
            .build()

        component = DaggerBaseComponent.builder()
            .contextComponent(applicationComponent)
            .build()


    }
}