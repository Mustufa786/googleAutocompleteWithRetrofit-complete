package com.codixlab.retrofitandplaceautocompleteapi.di.module

import com.codixlab.retrofitandplaceautocompleteapi.source.GeneralRemoteDataSource
import com.codixlab.retrofitandplaceautocompleteapi.source.GeneralRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * created by Mustufa Ansari on 20,August,2020
 * Email : mustufaayub82@gmail.com
 */
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun getGeneralRepository(generalRemoteDataSource: GeneralRemoteDataSource): GeneralRepository {
        return GeneralRepository(generalRemoteDataSource)
    }

    @Provides
    @Singleton
    fun getGeneralRemoteDataSource(): GeneralRemoteDataSource {
        return GeneralRemoteDataSource()
    }
}