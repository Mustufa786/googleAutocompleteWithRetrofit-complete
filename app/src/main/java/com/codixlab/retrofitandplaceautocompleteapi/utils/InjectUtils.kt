package com.codixlab.retrofitandplaceautocompleteapi.utils

import android.app.Application
import android.content.res.Resources
import com.codixlab.retrofitandplaceautocompleteapi.DaggerApp
import com.codixlab.retrofitandplaceautocompleteapi.retrofit.APIHostUrls
import com.codixlab.retrofitandplaceautocompleteapi.source.GeneralRepository

/**
 * Created by Mustufa Ansari on 12/10/2020.
 * Copyright (c) 2020 All rights reserved.
 */
object InjectUtils {

    val appContext: Application
        get() = DaggerApp.component?.getBaseContext()!!

    val resources: Resources
        get() = DaggerApp.component?.getResources()!!

    val getRetrofit: APIHostUrls
        get() = DaggerApp.component?.getRetrofitInstance()!!

    val getGeneralRepository: GeneralRepository
        get() = DaggerApp.component?.getGeneralRepository()!!

}