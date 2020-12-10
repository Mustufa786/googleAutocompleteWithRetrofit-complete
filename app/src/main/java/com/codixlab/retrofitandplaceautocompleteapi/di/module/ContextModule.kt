package com.codixlab.retrofitandplaceautocompleteapi.di.module

import android.app.Application
import dagger.Module
import dagger.Provides

/**
 * created by Mustufa Ansari on 18,August,2020
 * Email : mustufaayub82@gmail.com
 */
@Module
class ContextModule(var mApplication: Application?) {

    @Provides
    fun providesContext(): Application {
        return mApplication!!
    }
}