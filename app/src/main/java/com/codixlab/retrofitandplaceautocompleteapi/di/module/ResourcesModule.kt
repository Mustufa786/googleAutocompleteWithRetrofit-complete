package com.codixlab.retrofitandplaceautocompleteapi.di.module

import android.app.Application
import android.content.res.AssetManager
import android.content.res.Resources
import dagger.Module
import dagger.Provides

/**
 * Created by Mustufa Ansari on 10/12/2020.
 * Email : mustufaayub82@gmail.com
 */
@Module
class ResourcesModule {
    @Provides
    fun providesAssets(app: Application): AssetManager {
        return app.assets
    }
    @Provides
    fun providesResources(app: Application): Resources {
        return app.resources
    }

}