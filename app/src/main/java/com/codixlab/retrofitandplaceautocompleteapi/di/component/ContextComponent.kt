package com.codixlab.retrofitandplaceautocompleteapi.di.component

import android.app.Application
import com.codixlab.retrofitandplaceautocompleteapi.di.module.ContextModule
import dagger.Component

/**
 * created by Mustufa Ansari on 18,August,2020
 * Email : mustufaayub82@gmail.com
 */
@Component(modules = [ContextModule::class])
interface ContextComponent {
    fun getContext(): Application

}