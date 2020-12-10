package com.codixlab.retrofitandplaceautocompleteapi

import android.content.Context
import androidx.lifecycle.LifecycleObserver

/**
 * Created by Mustufa Ansari on 12/10/2020.
 * Copyright (c) 2020 All rights reserved.
 */
class MyApp : DaggerApp(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()
        if (application == null) {
            application = this
        }

    }

    companion object {
        var application: MyApp? = null
            private set

        val context: Context
            get() = application!!.applicationContext
    }
}